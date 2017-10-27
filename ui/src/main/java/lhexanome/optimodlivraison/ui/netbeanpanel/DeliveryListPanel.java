package lhexanome.optimodlivraison.ui.netbeanpanel;

import lhexanome.optimodlivraison.platform.models.Delivery;
import lhexanome.optimodlivraison.platform.models.RoadMap;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hugues
 */
public class DeliveryListPanel extends javax.swing.JPanel {

    private Map<Delivery,DeliveryPanel> deliverys;
    /**
     * Creates new form DeliveryListPanel
     */
    public DeliveryListPanel(Set<Delivery> deliveries, RoadMap roadMap) {
        deliverys = new HashMap<>();
        for(Delivery delivery : deliveries)
            deliverys.put(delivery,new DeliveryPanel(delivery, roadMap));

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());

        int[] pos = {0};
        deliverys.forEach((delivery, deliveryPanel) -> {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = pos[0];
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.weightx = 0.1;
            gridBagConstraints.weighty = 0.1;
            add(deliveryPanel,gridBagConstraints);
            pos[0] ++;
        });

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
