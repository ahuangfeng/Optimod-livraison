package lhexanome.optimodlivraison.ui.controller;

import lhexanome.optimodlivraison.platform.models.DeliveryOrder;
import lhexanome.optimodlivraison.platform.models.RoadMap;
import lhexanome.optimodlivraison.platform.models.Tour;
import lhexanome.optimodlivraison.ui.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Main controller.
 */
public class MainController implements ControllerInterface {

    /**
     * Main window.
     */
    private final MainWindow mainWindow;

    /**
     * Road map controller.
     */
    private final RoadMapController roadMapController;

    /**
     * DeliveryOrder controller.
     */
    private final DeliveryOrderController deliveryOrderController;

    /**
     * Tour controller.
     */
    private final TourController tourController;


    /**
     * Constructor.
     */
    public MainController() {
        roadMapController = new RoadMapController(this);
        deliveryOrderController = new DeliveryOrderController(this);
        tourController = new TourController(this);

        mainWindow = new MainWindow(
                this,
                roadMapController.getContentPane(),
                deliveryOrderController.getContentPane(),
                tourController.getContentPane()
        );
    }

    /**
     * {@link ControllerInterface#start()}.
     */
    @Override
    public void start() {
        mainWindow.open();
    }

    /**
     * {@link ControllerInterface#getContentPane()}.
     */
    @Override
    public Container getContentPane() {
        return mainWindow.getFrame();
    }

    /**
     * {@link ControllerInterface#closeWindow()}.
     */
    @Override
    public void closeWindow() {
        mainWindow.close();
    }

    /**
     * Select a new road map.
     *
     * @param xmlFile Map file
     */
    public void selectRoadMap(File xmlFile) {
        roadMapController.selectRoadMap(xmlFile);
    }

    /**
     * Select a delivery order.
     *
     * @param xmlFile Delivery order file
     */
    public void selectDeliveryOrder(File xmlFile) {
        deliveryOrderController.selectDeliveryOrder(xmlFile, roadMapController.getRoadMap());
    }

    /**
     * Road map setter.
     *
     * @param roadMap Road map
     */
    public void setRoadMap(RoadMap roadMap) {
        // TODO Clear delivery and tour data
    }

    /**
     * Delivery order setter.
     *
     * @param deliveryOrder Delivery order
     */
    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        roadMapController.setDeliveryOrder(deliveryOrder);
    }

    /**
     * Tour setter.
     *
     * @param tour Tour
     */
    public void setTour(Tour tour) {
        roadMapController.setTour(tour);
    }

    /**
     * Notify a error to the user.
     *
     * @param errorMessage Error message
     */
    public void notifyError(String errorMessage) {
        JOptionPane.showMessageDialog(mainWindow.getFrame(), errorMessage, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Compute a tour.
     */
    public void computeTour() {
        // TODO Check if available otherwise send an error message ?
        tourController.computeTour(
                roadMapController.getRoadMap(),
                deliveryOrderController.getDeliveryOrder()
        );
    }
}