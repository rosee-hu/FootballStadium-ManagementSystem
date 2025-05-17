/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import com.mycompany.footballstadiumticketsystem.Categ;
import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.Categories;
import com.mycompany.footballstadiumticketsystem.model.Customer;
import com.mycompany.footballstadiumticketsystem.model.Invoice;
import com.mycompany.footballstadiumticketsystem.model.Matchticket;
import com.mycompany.footballstadiumticketsystem.model.Services;
import com.mycompany.footballstadiumticketsystem.model.Teams;
import com.mycompany.footballstadiumticketsystem.model.Ticket;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FrInvoice extends javax.swing.JFrame {

    /**
     * Creates new form FrInvoice
     */
    Invoice invoice = new Invoice();
    Matchticket matchticket = new Matchticket();
    Services services = new Services();
    Customer customer;

    public FrInvoice(int matchTicketId,Customer c) {
        initComponents();
        ds = new DataService();
        this.customer=c;
        matchticket.setMatchTicketId(matchTicketId);
        tableemp(matchTicketId);
        getCategory();
        txtCount1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
    }
    DataService ds;

    private FrInvoice() {
    }

    FrInvoice(int matchTicketId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public void getCategory() {
        try {

            cbCate.removeAllItems();
//  
            ArrayList<Categories> categorieses = ds.SelectCategories();
//        
            for (int i = 0; i < categorieses.size(); i++) {

                cbCate.setModel(new DefaultComboBoxModel(categorieses.toArray()));
            }

        } catch (Exception ex) {
            System.out.println("dsd" + ex.getMessage());
        }
    }
    ArrayList<Services> serviceses;

    public void getService(int cat) {
        try {

            cbService.removeAllItems();
//  
            serviceses = ds.SelectServicesByCategorieId(cat);
//        
            for (int i = 0; i < serviceses.size(); i++) {

                cbService.setModel(new DefaultComboBoxModel(serviceses.toArray()));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    ArrayList<Invoice> listInvoices;

    public void tableemp(int mid) {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"InvoceId", "ServiceId", "ServiceName",
            "ServiceType", "Price", "Count", "CategorieId", "CategorieName"}, 0);
        listInvoices = ds.SelectInvoice(mid);

        Object rowdata[] = new Object[8];
        //System.out.println("size" + list.size());
        for (int i = 0; i < listInvoices.size(); i++) {
            rowdata[0] = listInvoices.get(i).getInvoiceId();
            rowdata[1] = listInvoices.get(i).getServices().getServiceId();
            rowdata[2] = listInvoices.get(i).getServices().getServiceName();
            rowdata[3] = listInvoices.get(i).getServices().getServiceType();
            rowdata[4] = listInvoices.get(i).getServices().getPrice();
            rowdata[5] = listInvoices.get(i).getCount();

            rowdata[6] = listInvoices.get(i).getServices().getCategories().getCategorieId();
            rowdata[7] = listInvoices.get(i).getServices().getCategories().getCategorieName();

            model.addRow(rowdata);
        }

        jTable2.setModel(model);
    }

    public void addInvoice() {
        int result = 0;

        if (txtCount1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {

            invoice.setMatchticket(matchticket);
            invoice.setCount(Integer.parseInt(txtCount1.getText()));
            invoice.setServices(services);

            try {
                if (ds.InsertInvoice(invoice) == 1) {
                    //   tableemp();
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
        if (txtInvoiceId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {

            invoice.setMatchticket(matchticket);
            invoice.setCount(Integer.parseInt(txtCount1.getText()));
            invoice.setServices(services);
            // teams.setDateOfEstablishment( dtTeam.getDate());
            // datev.setText(dtTeam.getDate().toString());
            // teams.setDateOfEstablishment((Date) datev.getText());

            ds.updateInvoice(Integer.valueOf(txtInvoiceId.getText()), invoice);

        }

    }

    public void cleanTextBox() {

        txtCount1.setText("");
        txtInvoiceId.setText("");
        txtPrice.setText("");
        txtTotelService.setToolTipText("");
        btSave.setEnabled(true);
        btUpdate.setEnabled(false);
        btDelete.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbService = new javax.swing.JComboBox();
        cbCate = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        txtCount1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTotelService = new javax.swing.JTextField();
        btDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtInvoiceId = new javax.swing.JTextField();
        btSave2 = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 22, -1));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Invoice");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 360, -1));
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 100));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 100));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("Service Name");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 103, -1));

        jLabel19.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 0));
        jLabel19.setText("Price");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 50, -1));

        txtPrice.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 102, 0));
        txtPrice.setBorder(null);
        txtPrice.setEnabled(false);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
        });
        jPanel3.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 90, 35));

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 102, 0));
        btSave.setText("Add");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        jLabel17.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("Invoice Id");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        cbService.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbService.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServiceItemStateChanged(evt);
            }
        });
        cbService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbServiceMouseEntered(evt);
            }
        });
        cbService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServiceActionPerformed(evt);
            }
        });
        jPanel3.add(cbService, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 380, -1));

        cbCate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbCate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCateItemStateChanged(evt);
            }
        });
        cbCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbCateMouseEntered(evt);
            }
        });
        cbCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCateActionPerformed(evt);
            }
        });
        jPanel3.add(cbCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 380, -1));

        jLabel20.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("Count");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 76, -1));

        txtCount1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtCount1.setForeground(new java.awt.Color(255, 102, 0));
        txtCount1.setBorder(null);
        txtCount1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCount1CaretUpdate(evt);
            }
        });
        txtCount1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCount1FocusGained(evt);
            }
        });
        jPanel3.add(txtCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 135, 90, 30));

        jLabel21.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 102, 0));
        jLabel21.setText("Total");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 50, -1));

        txtTotelService.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtTotelService.setForeground(new java.awt.Color(255, 102, 0));
        txtTotelService.setBorder(null);
        txtTotelService.setEnabled(false);
        txtTotelService.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotelServiceFocusGained(evt);
            }
        });
        jPanel3.add(txtTotelService, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 90, 35));

        btDelete.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 102, 0));
        btDelete.setText("Delete");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 100, -1));

        jScrollPane2.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable2.setGridColor(new java.awt.Color(247, 247, 247));
        jTable2.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 670, 240));

        jLabel22.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 0));
        jLabel22.setText("Category");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, -1));

        txtInvoiceId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtInvoiceId.setForeground(new java.awt.Color(255, 102, 0));
        txtInvoiceId.setBorder(null);
        txtInvoiceId.setEnabled(false);
        txtInvoiceId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtInvoiceIdCaretUpdate(evt);
            }
        });
        txtInvoiceId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtInvoiceIdFocusGained(evt);
            }
        });
        jPanel3.add(txtInvoiceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 370, 30));

        btSave2.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave2.setForeground(new java.awt.Color(255, 102, 0));
        btSave2.setText("Clear");
        btSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSave2ActionPerformed(evt);
            }
        });
        jPanel3.add(btSave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 100, -1));

        btUpdate.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 102, 0));
        btUpdate.setText("Updata");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 100, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 108, 660, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public  void getHome(){
      new Home(customer).setVisible(true);
  }
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

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceFocusGained

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            addInvoice();

             cleanTextBox();
 tableemp(matchticket.getMatchTicketId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " error" + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void cbServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServiceItemStateChanged

    }//GEN-LAST:event_cbServiceItemStateChanged

    private void cbServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbServiceMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiceMouseClicked

    private void cbServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbServiceMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiceMouseEntered

    private void cbServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiceActionPerformed

        services = new Services();
        if (categories.getCategorieId() != 0) {
            services = (Services) cbService.getSelectedItem();
            txtPrice.setText(String.valueOf(services.getPrice()));
        }
    }//GEN-LAST:event_cbServiceActionPerformed

    private void cbCateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCateItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCateItemStateChanged

    private void cbCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCateMouseClicked

    private void cbCateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCateMouseEntered

    Categories categories = new Categories();
    private void cbCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCateActionPerformed
        categories = (Categories) cbCate.getSelectedItem();

        if (categories != null) {
            getService(categories.getCategorieId());
        }

    }//GEN-LAST:event_cbCateActionPerformed

    private void txtCount1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCount1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCount1FocusGained

    private void txtTotelServiceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotelServiceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotelServiceFocusGained

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (check == 0) {
            int empId = Integer.valueOf(txtInvoiceId.getText());
            ds.deleteInvoice(empId);
            cleanTextBox();
            tableemp(matchticket.getMatchTicketId());
        }
    }//GEN-LAST:event_btDeleteActionPerformed


    private void txtCount1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCount1CaretUpdate
        try {
             if(!txtPrice.getText().equals(""))
        txtTotelService.setText(Double.parseDouble(txtPrice.getText()) * Integer.parseInt(txtCount1.getText()) + "");
        } catch (Exception e) {
        }
       // = price * Double.valueOf(txtNum1.getText());

    }//GEN-LAST:event_txtCount1CaretUpdate


    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        this.invoice = new Invoice();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        categories = new Categories();
        String catName;
        int selectedrow = jTable2.getSelectedRow();
        txtInvoiceId.setText(model.getValueAt(selectedrow, 0).toString());
        categories.setCategorieId(Integer.parseInt(model.getValueAt(selectedrow, 6).toString()));
        categories.setCategorieName(model.getValueAt(selectedrow, 7).toString());

        txtCount1.setText((model.getValueAt(selectedrow, 5).toString()));
        txtPrice.setText((model.getValueAt(selectedrow, 4).toString()));
        cbCate.getModel().setSelectedItem(categories);
        btUpdate.setEnabled(true);
        btDelete.setEnabled(true);
        btSave.setEnabled(false);
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtInvoiceIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtInvoiceIdCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoiceIdCaretUpdate

    private void txtInvoiceIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInvoiceIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoiceIdFocusGained

    private void btSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSave2ActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        updateData();
        tableemp(matchticket.getMatchTicketId());
        cleanTextBox();
    }//GEN-LAST:event_btUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(FrInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSave2;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox cbCate;
    private javax.swing.JComboBox cbService;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCount1;
    private javax.swing.JTextField txtInvoiceId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTotelService;
    // End of variables declaration//GEN-END:variables
}
