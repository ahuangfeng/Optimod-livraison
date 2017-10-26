package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.platform.models.DeliveryOrder;
import lhexanome.optimodlivraison.platform.models.RoadMap;
import lhexanome.optimodlivraison.platform.models.Tour;
import lhexanome.optimodlivraison.ui.component.RoadMapComponent;
import lhexanome.optimodlivraison.ui.controller.RoadMapController;

import javax.swing.*;
import java.awt.*;

/**
 * Panel containing a road map and some related buttons.
 */
public class RoadMapPanel extends AbstractPanel {

    /**
     * Road map component.
     */
    private RoadMapComponent roadMapComponent;

    /**
     * Content panel.
     */
    private JPanel contentPane;

    /**
     * Button to reload the map.
     */
    private JButton reloadRoadMapButton;

    /**
     * Constructor.
     *
     * @param controller Road map controller.
     */
    public RoadMapPanel(RoadMapController controller) {
        super(controller);
        setup();
    }

    /**
     * {@link AbstractPanel#setup()}.
     */
    @Override
    public void setup() {
        reloadRoadMapButton.addActionListener(e -> ((RoadMapController) controller).reloadMap());
    }

    /**
     * {@link AbstractPanel#getContentPane()}.
     */
    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    /**
     * Delivery order setter.
     * Called by the controller. Forwarded to roadMapComponent.
     *
     * @param deliveryOrder New delivery order
     */
    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        roadMapComponent.setDeliveryOrder(deliveryOrder);
    }

    /**
     * Road Map setter.
     * Called by the controller. Forwarded to roadMapComponent.
     *
     * @param roadMap New road map
     */
    public void setRoadMap(RoadMap roadMap) {
        this.roadMapComponent.setRoadMap(roadMap);
    }

    /**
     * Tour setter.
     * Called by the controller. Forwarded to roadMapComponent.
     *
     * @param tour New tour
     */
    public void setTour(Tour tour) {
        roadMapComponent.setTour(tour);
    }

    // Disable Checkstyle for generated code
    //CHECKSTYLE:OFF

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-65528)), null));
        reloadRoadMapButton = new JButton();
        reloadRoadMapButton.setText("Recharger un plan");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.02;
        gbc.weighty = 0.01;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(reloadRoadMapButton, gbc);
        roadMapComponent = new RoadMapComponent();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        contentPane.add(roadMapComponent, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.44;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.44;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(spacer2, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
