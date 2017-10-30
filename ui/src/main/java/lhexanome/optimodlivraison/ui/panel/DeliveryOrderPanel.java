package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.platform.models.DeliveryOrder;
import lhexanome.optimodlivraison.platform.models.RoadMap;
import lhexanome.optimodlivraison.ui.controller.DeliveryOrderController;

import javax.swing.*;
import java.awt.*;

/**
 * Delivery order panel.
 */
public class DeliveryOrderPanel extends AbstractPanel {

    /**
     * Content panel.
     */
    private JPanel contentPane;

    /**
     * Button to load delivery order.
     */
    private JButton loadDeliveryOrderButton;

    /**
     * Netbeans panel for a delivery order panel.
     */
    private lhexanome.optimodlivraison.ui.netbeanpanel.DeliveryOrderPanel deliveryOrderPanel;

    /**
     * Current delivery order.
     */
    private DeliveryOrder deliveryOrder;

    /**
     * Constructor.
     *
     * @param controller Delivery order controller
     */
    public DeliveryOrderPanel(DeliveryOrderController controller) {
        super(controller);
        setup();
    }

    /**
     * {@link AbstractPanel#setup()}.
     */
    @Override
    public void setup() {
        loadDeliveryOrderButton.addActionListener(e -> ((DeliveryOrderController) controller).reloadDeliveryOrder());
    }

    /**
     * Delivery order setter.
     * Called by the controller.
     *
     * @param newDeliveryOrder Delivery order
     * @param roadMap          roadMap
     */
    public void setData(DeliveryOrder newDeliveryOrder, RoadMap roadMap) {
        this.deliveryOrder = newDeliveryOrder;
        deliveryOrderPanel.setData(newDeliveryOrder, roadMap);
        contentPane.revalidate();
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
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

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
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(31);
        scrollPane1.setVerticalScrollBarPolicy(20);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(scrollPane1, gbc);
        deliveryOrderPanel = new lhexanome.optimodlivraison.ui.netbeanpanel.DeliveryOrderPanel();
        scrollPane1.setViewportView(deliveryOrderPanel);
        loadDeliveryOrderButton = new JButton();
        loadDeliveryOrderButton.setText("Charger demande de livraison");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 0, 5, 0);
        contentPane.add(loadDeliveryOrderButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
