/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.Customer;
import com.mycompany.footballstadiumticketsystem.model.Matchticket;
import com.mycompany.footballstadiumticketsystem.model.PaymentCach;
import com.mycompany.footballstadiumticketsystem.model.PaymentCard;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class jFrPaymentCach extends javax.swing.JFrame {

    /**
     * Creates new form jFrPaymentCach
     */
    Matchticket matchticket = new Matchticket();

    Customer customer;
    public jFrPaymentCach(int matchTicketId,Customer c,double Amount) {
        initComponents();
        ds = new DataService();
        this.customer=c;
        txtAmount.setText(Amount+"");
        txtPayment.setText(Amount+"");
        matchticket.setMatchTicketId(matchTicketId);
        tableemp(matchTicketId);
        txtPaymentId.setText((matchTicketId)+"");
        txtPayment.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
    }
    DataService ds;
    ArrayList<PaymentCach> listPaymentCach;

    private jFrPaymentCach() {
    }
   public void tableemp(int mid) {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"PaymentId", "DatePay", "Amount"}, 0);
        listPaymentCach = ds.SelectPaymentcach(mid);

        Object rowdata[] = new Object[8];
        //System.out.println("size" + list.size());
        for (int i = 0; i < listPaymentCach.size(); i++) {
            rowdata[0] = listPaymentCach.get(i).getPaymentId();
            rowdata[1] = listPaymentCach.get(i).getDatePay();
            rowdata[2] = listPaymentCach.get(i).getAmount();
         

            model.addRow(rowdata);
        }

    }
   PaymentCach paymentCach=new PaymentCach();
 public void addPaymentcach() {
        int result = 0;

        if (txtPayment.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        
            
             } 
        else if(Double.parseDouble(txtPayment.getText().toString())>Double.parseDouble(txtAmount.getText().toString())){
   JOptionPane.showMessageDialog(this, "Payment Max of Amount.", "Entry Error", 1);
 
        }
        else if(Double.parseDouble(txtPayment.getText().toString())<Double.parseDouble(txtAmount.getText().toString())){
   JOptionPane.showMessageDialog(this, "Payment Min of Amount.", "Entry Error", 1);
 
        }
            else {

            
            paymentCach.setMatchticket(matchticket);
            paymentCach.setAmount(Double.parseDouble(txtPayment.getText()));
          paymentCach.setDatePay(new java.sql.Date(dtPayment.getDate().getTime()));

            try {
                if (ds.InsertPaymentcach(paymentCach) == 1) {
                    tableemp(matchticket.getMatchTicketId());
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }

                //   con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TickesUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void updateData() {

        //actionGender().equals("not selected")
        if (txtPaymentId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {

              paymentCach.setMatchticket(matchticket);
            paymentCach.setAmount(Double.parseDouble(txtPayment.getText()));
          paymentCach.setDatePay(new java.sql.Date(dtPayment.getDate().getTime()));
            ds.updatePaymentCach(Integer.valueOf(txtPaymentId.getText()), paymentCach);

        }

    }

  public void cleanTextBox() {

        txtPaymentId.setText("");
        txtPayment.setText("");
       
       
        btSave.setEnabled(true);
       

    }
  
  public  void getHome(){
        dispose();
            new Home(customer).setVisible(true);
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSave = new javax.swing.JButton();
        txtPayment = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dtPayment = new com.toedter.calendar.JDateChooser();
        txtPaymentId = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 102, 0));
        btSave.setText("Add");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 430, -1));

        txtPayment.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPayment.setForeground(new java.awt.Color(255, 102, 0));
        txtPayment.setBorder(null);
        txtPayment.setEnabled(false);
        txtPayment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaymentFocusGained(evt);
            }
        });
        txtPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentActionPerformed(evt);
            }
        });
        getContentPane().add(txtPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 100, 35));

        jLabel19.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 0));
        jLabel19.setText("Date Payment");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));

        jLabel20.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("Amount");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 60, 30));

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Lemonada SemiBold", 0, 24)); // NOI18N
        jLabel13.setText("Football Stadium Ticket System");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 510, 40));

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 22, -1));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Invoice");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 360, -1));
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 100));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 100));

        dtPayment.setDateFormatString("dd‏/MM‏/y ");
        dtPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtPaymentMouseClicked(evt);
            }
        });
        getContentPane().add(dtPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 230, 30));

        txtPaymentId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPaymentId.setForeground(new java.awt.Color(255, 102, 0));
        txtPaymentId.setBorder(null);
        txtPaymentId.setEnabled(false);
        txtPaymentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaymentIdFocusGained(evt);
            }
        });
        txtPaymentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtPaymentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 125, 70, 30));

        jLabel23.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 102, 0));
        jLabel23.setText("Payment Id");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 100, -1));

        jLabel21.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 102, 0));
        jLabel21.setText("Payment");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 121, 60, 30));

        txtAmount.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(255, 102, 0));
        txtAmount.setBorder(null);
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAmountFocusGained(evt);
            }
        });
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        getContentPane().add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 100, 35));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
        addPaymentcach();
        dispose();
        getHome();
        cleanTextBox();
            //tableemp(matchticket.getMatchTicketId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " error" + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void txtPaymentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaymentFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentFocusGained

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        dispose();
        getHome();
        
    }//GEN-LAST:event_exitMousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        //   this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //  xx = evt.getX();
        // xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void txtPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentActionPerformed

    private void dtPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtPaymentMouseClicked
    }//GEN-LAST:event_dtPaymentMouseClicked

    private void txtPaymentIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaymentIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentIdFocusGained

    private void txtPaymentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentIdActionPerformed

    private void txtAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountFocusGained

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(jFrPaymentCach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrPaymentCach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrPaymentCach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrPaymentCach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrPaymentCach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private com.toedter.calendar.JDateChooser dtPayment;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtPayment;
    private javax.swing.JTextField txtPaymentId;
    // End of variables declaration//GEN-END:variables
}
