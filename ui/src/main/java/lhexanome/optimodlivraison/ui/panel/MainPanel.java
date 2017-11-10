package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.ui.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Main panel of the application.
 * Contains the other panels.
 */
public class MainPanel extends AbstractPanel {
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
        gbc.gridheight = 3;

        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.ipadx = 1;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;

        wrapperPanel.add(deliveryOrderPanel, gbc);
        wrapperPanel.add(tourEditorPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;

        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;

        wrapperPanel.add(roadMapPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weighty = 0;
        gbc.weightx = 0;

        gbc.ipady = 20;
        wrapperPanel.add(currentInterectionDisplayPanel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.ipady = 0;

        wrapperPanel.add(tourPanel, gbc);

        contentPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK),
                "undoMapKey");
        contentPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK),
            "redoMapKey");
        contentPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK),
                "redoMapKey");

        Action undoAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((MainController) controller).undo();
            }
        };
        Action redoAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((MainController) controller).redo();
            }
        };
        contentPane.getActionMap().put("undoMapKey", undoAction);
        contentPane.getActionMap().put("redoMapKey", redoAction);

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
