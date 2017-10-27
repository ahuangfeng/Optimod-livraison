package lhexanome.optimodlivraison.platform.parsing;

import lhexanome.optimodlivraison.platform.exceptions.ParseDeliveryOrderException;
import lhexanome.optimodlivraison.platform.models.Delivery;
import lhexanome.optimodlivraison.platform.models.DeliveryOrder;
import lhexanome.optimodlivraison.platform.models.Intersection;
import lhexanome.optimodlivraison.platform.models.RoadMap;
import lhexanome.optimodlivraison.platform.models.Warehouse;
import org.jdom2.Element;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Parser d'un document XML représentant une demande de livraison.
 */
public class DeliveryOrderParser {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(DeliveryOrderParser.class.getName());

    /**
     * XML Root element.
     */
    public static final String XML_ROOT_ELEMENT = "demandeDeLivraisons";

    /**
     * XML Warehouse element.
     */
    public static final String XML_WAREHOUSE_ELEMENT = "entrepot";

    /**
     * XML delivery element.
     */
    public static final String XML_DELIVERY_ELEMENT = "livraison";

    /**
     * XML address attribute.
     */
    public static final String XML_ADDRESS_ATRTRIBUTE = "adresse";

    /**
     * XML duration attribute.
     */
    public static final String XML_DURATION_ATTRIBUTE = "duree";

    /**
     * XML start time attribute.
     */
    public static final String XML_START_TIME_ATTRIBUTE = "heureDepart";


    /**
     * Parse un document XML représentant une demande de livraison.
     * Utilise le format suivant :
     * {@code
     * <demandeDeLivraisons>
     * <entrepot adresse="1" heureDepart="8:0:0"/>
     * <livraison adresse="2" duree="900"/>
     * <livraison adresse="3" duree="600"/>
     * </demandeDeLivraisons>
     * }
     *
     * @param rootElement Element racine
     * @param roadMap     RoadMap already initialized to bind X and Y
     * @return Une demande de livraison
     * @throws ParseDeliveryOrderException Si un problème a lieu lors du parsing
     */
    public DeliveryOrder parseDeliveryOrder(Element rootElement, RoadMap roadMap) throws ParseDeliveryOrderException {
        DeliveryOrder deliveryOrder = new DeliveryOrder();

        LOGGER.info("Start parsing delivery order");

        if (!XML_ROOT_ELEMENT.equals(rootElement.getName())) {
            throw new ParseDeliveryOrderException(
                    String.format("XML root element name must be `%s`", XML_ROOT_ELEMENT));
        }
        rootElement.getChildren(XML_ROOT_ELEMENT);

        List<Element> warehouseList = rootElement.getChildren(XML_WAREHOUSE_ELEMENT);
        List<Element> deliveries = rootElement.getChildren(XML_DELIVERY_ELEMENT);

        if (warehouseList.size() > 1) {
            throw new ParseDeliveryOrderException("XML contains too many warehouses");
        }

        if (warehouseList.size() == 0) {
            throw new ParseDeliveryOrderException("XML does not have a warehouse");
        }

        if (warehouseList.size() + deliveries.size() != rootElement.getChildren().size()) {
            throw new ParseDeliveryOrderException("XML contains unknown elements");
        }

        loadWarehouse(warehouseList.get(0), deliveryOrder, roadMap);

        LOGGER.info("Warehouse loaded");

        loadDeliveries(deliveries, deliveryOrder, roadMap);

        LOGGER.info("End parsing delivery order");
        return deliveryOrder;
    }

    /**
     * Charge l'entrepôt et l'heure de départ.
     *
     * @param element       Element représentant l'entrepôt
     * @param deliveryOrder Demande de livraison
     * @param roadMap       RoadMap used to find intersection
     * @throws ParseDeliveryOrderException Si la structure est mauvaise
     */
    public void loadWarehouse(Element element, DeliveryOrder deliveryOrder, RoadMap roadMap)
            throws ParseDeliveryOrderException {

        String startTime = element.getAttributeValue(XML_START_TIME_ATTRIBUTE);

        if (startTime == null) {
            throw new ParseDeliveryOrderException("Warehouse element is missing attribute" + XML_START_TIME_ATTRIBUTE);
        }

        DateFormat dateFormat = new SimpleDateFormat("H:m:s");

        Warehouse warehouse = new Warehouse(findIntersectionFromElement(element, roadMap));

        // FIXME Start time in warehouse ?
        try {
            Date date = dateFormat.parse(startTime);

            deliveryOrder.setBeginning(warehouse);
            deliveryOrder.setStart(date);

        } catch (ParseException e) {
            throw new ParseDeliveryOrderException("Unable to parse date");
        }
    }

    /**
     * Charge les livraisons.
     *
     * @param deliveries    Liste d'élements représentant des livraisons
     * @param deliveryOrder Demande de livraison
     * @param roadMap       RoadMap used to find intersection
     * @throws ParseDeliveryOrderException Si la structure est mauvaise
     */
    public void loadDeliveries(List<Element> deliveries, DeliveryOrder deliveryOrder, RoadMap roadMap)
            throws ParseDeliveryOrderException {

        for (Element delivery : deliveries) {
            if (delivery.getAttribute(XML_DURATION_ATTRIBUTE) == null) {
                throw new ParseDeliveryOrderException(
                        String.format("A delivery element is missing the `%s` attribute", XML_DURATION_ATTRIBUTE));
            }

            Intersection intersection = findIntersectionFromElement(delivery, roadMap);
            Integer duration = Integer.valueOf(delivery.getAttributeValue(XML_DURATION_ATTRIBUTE));

            Delivery delivery1 = new Delivery(intersection, duration);

            deliveryOrder.addDelivery(delivery1);
        }
    }

    /**
     * This function parse an XML element and return an intersection from RoadMap.
     * Raise an exception if the intersection is not found in the RoadMap or `element` is missing attributes.
     *
     * @param element XML Element
     * @param roadMap RoadMap
     * @return Intersection
     * @throws ParseDeliveryOrderException If the address is not found.
     */
    private Intersection findIntersectionFromElement(Element element, RoadMap roadMap)
            throws ParseDeliveryOrderException {

        String address = element.getAttributeValue(XML_ADDRESS_ATRTRIBUTE);

        if (address == null) {
            throw new ParseDeliveryOrderException(
                    String.format("An intersection is missing the `%s` attribute", XML_ADDRESS_ATRTRIBUTE));
        }

        Intersection intersection = roadMap.findIntersectionById(
                Long.valueOf(address));

        if (intersection == null) {
            throw new ParseDeliveryOrderException(
                    String.format("The intersection with id `%s` doesn't exists in the provided road map", address));
        }

        return intersection;
    }

}