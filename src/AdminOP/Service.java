package AdminOP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.footballstadiumticketsystem.Categ;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.Admin;
import com.mycompany.footballstadiumticketsystem.model.Categories;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import com.mycompany.footballstadiumticketsystem.model.Services;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ASUS
 */
public class Service extends javax.swing.JFrame {

    /**
     * Creates new form Service
     */
    public Categories c;
    String type = "Not Free";

    Admin admin = new Admin();

    public Service(Admin admin) {
        this.c = new Categories();
        this.c.setCategorieId(1);
        initComponents();
        this.admin = admin;
        ds = new DataService();
        tableemp();
        getCategory();
        txtPrice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });

    }

    private Service() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void TypeSelecyed() {
        if (rbFree.isSelected()) {
            type = "Free";
        }
        if (rbNotFree.isSelected()) {
            type = "Not Free";
        }
    }
    DataService ds;

    public void tableemp() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ServiceId", "ServiceName",
            "ServiceType", "Price", "CategorieId", "CategorieName"}, 0);
        ArrayList<Services> list = ds.SelectServices();
        Object rowdata[] = new Object[6];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getServiceId();
            rowdata[1] = list.get(i).getServiceName();
            rowdata[2] = list.get(i).getServiceType();
            rowdata[3] = list.get(i).getPrice();
            rowdata[4] = list.get(i).getCategories().getCategorieId();
            rowdata[5] = list.get(i).getCategories().getCategorieName();

            model.addRow(rowdata);
        }

        jTable2.setModel(model);
    }

    Services services = new Services();

    public void getCategory() {
        try {

            cbCate.removeAllItems();
            ArrayList<Categories> categorieses = ds.SelectCategories();
            for (int i = 0; i < categorieses.size(); i++) {

                cbCate.setModel(new DefaultComboBoxModel(categorieses.toArray()));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addTeam() throws SQLException {
        int result = 0;

        if (txtServiceName.getText().equals("") || txtPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            services.setServiceName(txtServiceName.getText());
            services.setServiceType(type);
            services.setPrice(Double.parseDouble(txtPrice.getText()));
            c.setCategorieId(c.getCategorieId());
            services.setCategories(c);

            if (ds.InsertServices(services) == 1) {
                tableemp();
                JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
            }

            //   con.close();
        }
    }

    public void cleanTextBox() {

        txtServiceName.setText("");
        txtPrice.setText("");
        txtServiceId.setText("");
        btSave.setEnabled(true);
        btUpdate.setEnabled(false);
        btDelete.setEnabled(false);

    }

    public void updateData() {

        if (txtServiceName.getText().equals("") || txtPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            services.setServiceName(txtServiceName.getText());
            services.setServiceType(type);
            services.setPrice(Double.parseDouble(txtPrice.getText()));
            this.c.setCategorieId(this.c.getCategorieId());
            services.setCategories(this.c);

            ds.updateServices(Integer.valueOf(txtServiceId.getText()), services);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtServiceId = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbFree = new javax.swing.JRadioButton();
        rbNotFree = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        cbCate = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        jTable1.setFont(new java.awt.Font("Lemonada SemiBold", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "nadi altasamuh "},
                {"2", "nadi altadamun "},
                {"3", "nadi altahami "},
                {"4", "nadi altuwbad "},
                {"5", "nadi sharura "},
                {"6", "nadi daba' "},
                {"7", "nadi najid "},
                {"8", "nadi sharura "}
            },
            new String [] {
                "Team Id", "Team Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(247, 247, 247));
        jTable1.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 2));
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
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 510, 40));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Service Football  Match");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 390, -1));
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 100));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        lbl_close.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_close.setText("X");
        lbl_close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_closeMouseMoved(evt);
            }
        });
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_closeMousePressed(evt);
            }
        });
        jPanel2.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 27, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1090, 130));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("Service Name");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 103, -1));

        txtServiceName.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtServiceName.setForeground(new java.awt.Color(255, 102, 0));
        txtServiceName.setBorder(null);
        txtServiceName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServiceNameFocusGained(evt);
            }
        });
        jPanel3.add(txtServiceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 270, 35));

        jLabel19.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 0));
        jLabel19.setText("Price");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 76, -1));

        txtPrice.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 102, 0));
        txtPrice.setText("0");
        txtPrice.setBorder(null);
        txtPrice.setEnabled(false);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
        });
        jPanel3.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 150, 270, 35));

        txtServiceId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtServiceId.setForeground(new java.awt.Color(255, 102, 0));
        txtServiceId.setBorder(null);
        txtServiceId.setEnabled(false);
        txtServiceId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServiceIdFocusGained(evt);
            }
        });
        jPanel3.add(txtServiceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 35));

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 102, 0));
        btSave.setText("Add");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 111, -1));

        btUpdate.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btUpdate.setForeground(new java.awt.Color(255, 102, 0));
        btUpdate.setText("Update");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 104, -1));

        jLabel21.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 102, 0));
        jLabel21.setText("Service Type");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 118, -1));

        jLabel17.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("Categories");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, -1));

        btDelete.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 102, 0));
        btDelete.setText("Delete");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 104, -1));

        buttonGroup1.add(rbFree);
        rbFree.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbFree.setText("Free");
        rbFree.setActionCommand("cbFree");
        rbFree.setName("rbFree"); // NOI18N
        rbFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFreeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNotFree);
        rbNotFree.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbNotFree.setText("Not Free");
        rbNotFree.setActionCommand("chNotFree");
        rbNotFree.setName("rbNotFree"); // NOI18N
        rbNotFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNotFreeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbNotFree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(rbFree)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNotFree)
                    .addComponent(rbFree))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 260, 80));

        jLabel20.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("Service Id");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 109, -1));

        btClear.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btClear.setForeground(new java.awt.Color(255, 102, 0));
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });
        jPanel3.add(btClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 111, -1));

        cbCate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCateActionPerformed(evt);
            }
        });
        jPanel3.add(cbCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 270, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 490, 330));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        jTable2.setFont(new java.awt.Font("Lemonada SemiBold", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setGridColor(new java.awt.Color(247, 247, 247));
        jTable2.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 151, 500, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        //   this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        dispose();
    }//GEN-LAST:event_jPanel2MousePressed

    private void txtServiceNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiceNameFocusGained

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtServiceIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiceIdFocusGained

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            addTeam();

            cleanTextBox();
            tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " error" + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        updateData();
        tableemp();

        cleanTextBox();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        this.services = new Services();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        int selectedrow = jTable2.getSelectedRow();
        txtServiceId.setText(model.getValueAt(selectedrow, 0).toString());
        txtServiceName.setText(model.getValueAt(selectedrow, 1).toString());
        txtPrice.setText(model.getValueAt(selectedrow, 3).toString());
        btUpdate.setEnabled(true);
        btDelete.setEnabled(true);
        btSave.setEnabled(false);
    }//GEN-LAST:event_jTable2MouseClicked

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (check == 0) {
            int empId = Integer.valueOf(txtServiceId.getText());
            ds.deleteServices(empId);
            cleanTextBox();
            tableemp();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void rbFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFreeActionPerformed
        TypeSelecyed(); 
        txtPrice.setEnabled(false);


// if choose gender this method call
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFreeActionPerformed

    private void rbNotFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNotFreeActionPerformed

        TypeSelecyed(); 

txtPrice.setEnabled(true);
// if choose gender this method call

    }//GEN-LAST:event_rbNotFreeActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        cleanTextBox();
    }//GEN-LAST:event_btClearActionPerformed

    private void lbl_closeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_closeMouseMoved

    private void lbl_closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMousePressed
        // TODO add your handling code here:
        // if (JOptionPane.showConfirmDialog(null, "Are you sure to close window ", "Warning", JOptionPane.WARNING_MESSAGE) == 0)

    }//GEN-LAST:event_lbl_closeMousePressed

    private void cbCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCateActionPerformed

        this.c = new Categories();
        c = (Categories) cbCate.getModel().getSelectedItem();
    }//GEN-LAST:event_cbCateActionPerformed

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        DashBorder m = new DashBorder(admin);
        m.setExtendedState(NORMAL);
        m.setVisible(true);
    }//GEN-LAST:event_lbl_closeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.setLookAndFeel(new FlatMacDarkLaf());

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Service().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCate;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JRadioButton rbFree;
    private javax.swing.JRadioButton rbNotFree;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtServiceId;
    private javax.swing.JTextField txtServiceName;
    // End of variables declaration//GEN-END:variables
}
