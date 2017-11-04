package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.ui.controller.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Main panel of the application.
 * Contains the other panels.
 */
public class MainPanel extends AbstractPanel {
    /**
     * Content panel.
     */
    private JPanel contentPane;

    /**
     * Wrapper panel.
     * Needed because other panels are initialized in the constructor,
     * after Intellij's functions.
     */
    private JPanel wrapperPanel;

    /**
     * Road map panel.
     */
    private final JPanel roadMapPanel;

    /**
     * Delivery order panel.
     */
    private final JPanel deliveryOrderPanel;

    /**
     * Tour panel.
     */
    private final JPanel tourPanel;

    /**
     * Tour editor panel.
     */
    private final JPanel tourEditorPanel;

    /**
     * Selected intersection panel.
     */
    private final JPanel currentInterectionDisplayPanel;

    /**
     * Constructor.
     *
     * @param controller                     Main controller
     * @param roadMapPanel                   Road map panel
     * @param deliveryOrderPanel             Delivery order panel
     * @param tourPanel                      Tour panel
     * @param tourEditorPanel                Tour editor panel
     * @param currentInterectionDisplayPanel current interection display panel
     */
    public MainPanel(MainController controller,
                     JPanel roadMapPanel,
                     JPanel deliveryOrderPanel,
                     JPanel tourPanel,
                     JPanel tourEditorPanel,
                     JPanel currentInterectionDisplayPanel) {
        super(controller);
        this.roadMapPanel = roadMapPanel;
        this.deliveryOrderPanel = deliveryOrderPanel;
        this.tourPanel = tourPanel;
        this.tourEditorPanel = tourEditorPanel;
        this.currentInterectionDisplayPanel = currentInterectionDisplayPanel;
        setup();
    }

    /**
     * {@link AbstractPanel#setup()}.
     * Here, dispose panels in the main panel.
     */
    @Override
    @SuppressWarnings("checkstyle:magicnumber")
    public void setup() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;
        wrapperPanel.add(deliveryOrderPanel, gbc);

        gbc.weightx = 0.6;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        wrapperPanel.add(roadMapPanel, gbc);

        gbc.gridy = 1;
        wrapperPanel.add(currentInterectionDisplayPanel, gbc);

        gbc.gridy = 2;
        wrapperPanel.add(tourPanel, gbc);

        gbc.gridheight = 2;
        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.weightx = 0.4;
        wrapperPanel.add(tourEditorPanel, gbc);
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
        contentPane.setLayout(new BorderLayout(0, 0));
        wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridBagLayout());
        contentPane.add(wrapperPanel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
