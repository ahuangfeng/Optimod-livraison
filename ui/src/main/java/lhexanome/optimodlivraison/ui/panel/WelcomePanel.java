package lhexanome.optimodlivraison.ui.panel;

import lhexanome.optimodlivraison.ui.controller.WelcomeController;

import javax.swing.*;
import java.awt.*;

/**
 * Welcome panel is the first display show to the user.
 */
public class WelcomePanel extends AbstractPanel {
    /**
     * Button to open a road map.
     */
    private JButton openRoadMapButton;

    /**
     * Panel containing the interface.
     */
    private JPanel contentPane;

    /**
     * Constructor.
     *
     * @param controller Welcome controller
     */
    public WelcomePanel(WelcomeController controller) {
        super(controller);
        setup();
    }

    /**
     * {@link AbstractPanel#setup()}.
     */
    @Override
    public void setup() {
        openRoadMapButton.addActionListener(e -> ((WelcomeController) controller).clickChooseRoadMap());
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
        contentPane.setBackground(new Color(-1));
        contentPane.setVisible(true);
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-1));
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$(null, -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Bienvenue sur Optimod livraison");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(50, 60, 15, 60);
        contentPane.add(label1, gbc);
        openRoadMapButton = new JButton();
        openRoadMapButton.setBackground(new Color(-1));
        openRoadMapButton.setText("Ouvrir un plan");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10, 0, 50, 0);
        contentPane.add(openRoadMapButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
