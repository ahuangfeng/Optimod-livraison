package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.platform.models.Delivery;
import lhexanome.optimodlivraison.platform.models.DeliveryOrder;
import lhexanome.optimodlivraison.ui.controller.DeliveryOrderController;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Delivery order panel.
 */
public class DeliveryOrderPanel extends AbstractPanel {

    /**
     * Content panel.
     */
    private JPanel contentPane;

    /**
     * JList displaying the orders.
     */
    private JList<String> deliveryJList;

    /**
     * Button to load delivery order.
     */
    private JButton loadDeliveryOrderButton;

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
     * @param deliveryOrder Delivery order
     */
    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        this.deliveryOrder = deliveryOrder;

        DefaultListModel<String> listModel = new DefaultListModel<>();

        Iterator<Delivery> deliverySet = deliveryOrder.getDeliveries().iterator();

        int i = 0;
        while (deliverySet.hasNext()) {
            Delivery currDelivery = deliverySet.next();

            i++;
        }

        deliveryJList.setModel(listModel);
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
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        contentPane.add(spacer1, gbc);
        loadDeliveryOrderButton = new JButton();
        loadDeliveryOrderButton.setText("Charger demande de livraison");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(loadDeliveryOrderButton, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(31);
        scrollPane1.setVerticalScrollBarPolicy(22);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(scrollPane1, gbc);
        deliveryJList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Livraison 1");
        defaultListModel1.addElement("Livriason 2");
        defaultListModel1.addElement("Livriason 3");
        defaultListModel1.addElement("Livriason 4");
        defaultListModel1.addElement("Livriason 5");
        defaultListModel1.addElement("Livriason 6");
        defaultListModel1.addElement("Livriason 7");
        defaultListModel1.addElement("Livriason 8");
        deliveryJList.setModel(defaultListModel1);
        deliveryJList.setSelectionMode(0);
        scrollPane1.setViewportView(deliveryJList);
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

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }


}