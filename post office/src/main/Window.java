
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Window extends JFrame {
    
    private final ButtonGroup check = new ButtonGroup();
    PostOffice office = new PostOffice();
    
    public Window() {
        
        // SETTINGS
        getContentPane().setBackground(Color.WHITE);
        setTitle("POST OFFICE");
        setPreferredSize(new Dimension(600,600));
        setResizable(false);
        
        // COMPONENTS
        setGroupCheckBox();
        setRemoveTicket();
        add(office); office.startThread();
        initComponents();
        
        setLocationRelativeTo(null);
    }
    
    public void setGroupCheckBox() {
        
        // CHECK BOX
        JCheckBox boxPayment = new JCheckBox("PAYMENT");
        boxPayment.setBounds(100, 100, 100, 50);
        
        JCheckBox boxShipment = new JCheckBox("SHIPMENT");
        boxShipment.setBounds(200, 100, 100, 50);
        
        check.add(boxPayment);
        check.add(boxShipment);
        
        this.add(boxPayment);
        this.add(boxShipment);
        
        // BUTTON CHECK
        JButton btnAction = new JButton("CREATE TICKET");
        btnAction.setBounds(300, 100, 200, 50);
        
        btnAction.addActionListener((ActionEvent e) -> {
                        
            if (boxPayment.isSelected()) {
                office.addUserToCounter(new User(new Ticket("PAYMENT")));
            }
            else if (boxShipment.isSelected()) {
                office.addUserToCounter(new User(new Ticket("SHIPMENT")));
            }
            else {JOptionPane.showMessageDialog(null, "Selezionare almeno una casella");}
            
            check.clearSelection();
            
            office.showPostOffice();
        });
        
        this.add(btnAction);
    }
    
    public void setRemoveTicket() {
        
        // TEXT FIELD
        JTextField txtCode = new JTextField();
        txtCode.setBounds(100, 200, 200, 50);
        
        this.add(txtCode);
        
        // BUTTON REMOVE
        JButton btnRemove = new JButton("REMOVE");
        btnRemove.setBounds(300, 200, 200, 50);
        
        btnRemove.addActionListener((ActionEvent e) -> {office.removeTicketFromTail(txtCode.getText());});
        
        this.add(btnRemove);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
