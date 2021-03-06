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
     * Loading label, the icon will be in it.
     */
    private JLabel loadingContainer;

    /**
     * Constructor.
     *
     * @param controller Road map controller.
     */
    public RoadMapPanel(RoadMapController controller) {
        super(controller);
        $$$setupUI$$$();
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


    /**
     * Set loading state.
     *
     * @param visible When true, map is loading
     */
    public void setLoading(boolean visible) {
        loadingContainer.setVisible(visible);
        roadMapComponent.setVisible(!visible);
    }

    /**
     * Initialize custom UI.
     */
    private void createUIComponents() {
        roadMapComponent = new RoadMapComponent((RoadMapController) controller);
    }

    /**
     * {@link AbstractPanel#getContentPane()}.
     */
    @Override
    public JPanel getContentPane() {
        return contentPane;

        // Disable Checkstyle for generated code
        //CHECKSTYLE:OFF
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        roadMapComponent.setEnabled(true);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(roadMapComponent, gbc);
        loadingContainer = new JLabel();
        loadingContainer.setHorizontalAlignment(0);
        loadingContainer.setIcon(new ImageIcon(getClass().getResource("/loading/double_ring.gif")));
        loadingContainer.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(loadingContainer, gbc);
        reloadRoadMapButton = new JButton();
        reloadRoadMapButton.setAlignmentY(0.0f);
        reloadRoadMapButton.setContentAreaFilled(true);
        reloadRoadMapButton.setFocusCycleRoot(false);
        reloadRoadMapButton.setHideActionText(false);
        reloadRoadMapButton.setHorizontalAlignment(0);
        reloadRoadMapButton.setHorizontalTextPosition(0);
        reloadRoadMapButton.setIconTextGap(0);
        reloadRoadMapButton.setMargin(new Insets(0, 0, 0, 0));
        reloadRoadMapButton.setText("Recharger un plan");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 10;
        gbc.ipady = 5;
        contentPane.add(reloadRoadMapButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
