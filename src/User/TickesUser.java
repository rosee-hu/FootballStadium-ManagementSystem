/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.Customer;
import com.mycompany.footballstadiumticketsystem.model.MatchFootball;
import com.mycompany.footballstadiumticketsystem.model.Matchticket;
import com.mycompany.footballstadiumticketsystem.model.Ticket;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class TickesUser extends javax.swing.JFrame {

    /**
     * Creates new form TickesUser
     */
    Customer customere;

    public TickesUser(int cid, Customer c) {
        initComponents();
        ds = new DataService();
        this.customere = c;
        this.CustomerId = cid;
        tableemp();
        txtParksId.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtSeatsId.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        randomId();
        txtParksId.setText(int_randomPeaksID+"");
        txtSeatsId.setText(int_randomSeateID+"");
                jPanel1.hide();

    }
    DataService ds;

    int id;
    String type;
    int CustomerId;

//    ArrayList<Matchticket> list;
    private TickesUser() {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void TypeSelecyed() {
        if (rbVip.isSelected()) {
            type = "Vip";
            id = Integer.parseInt(txtTicketId.getText());

        }
        if (rbNormal.isSelected()) {
            type = "Normal";
            id = Integer.parseInt(txtTicketIdNormal.getText());

        }
    }
    Matchticket matchticket = new Matchticket();

    public void addMatchticket() {
        int result = 0;

        if (txtSeatsId.getText().equals("") || txtParksId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            Customer customer = new Customer();
            customer.setId(CustomerId);
            Ticket ticket = new Ticket();
            ticket.setTicketId(id);


            matchticket.setParksId(Integer.parseInt(txtParksId.getText()));
            matchticket.setSeatesId(Integer.parseInt(txtSeatsId.getText()));
            matchticket.setPreson(customer);
            matchticket.setTicket(ticket);
//
            try {
                if (ds.InsertMatchticket(matchticket) == 1) {
                    tableemp();
                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }

                //   con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TickesUser.class.getName()).log(Level.SEVERE, null, ex);
//            }
            }}
    }
    //    ArrayList<Matchticket> list;
    ArrayList<MatchFootball> list;

    public void tableemp() {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"MatchNumber", "Home_TeamId",
            "Home_TeamName", "Away_TeamId", "Away_TeamName",
            "StadiumID", "StadiumName", "DateMatch", "TimeMatch", "City", "NumberSteas", "NumberOfParks"}, 0);
        list = ds.SelectMachFootball();
        Object rowdata[] = new Object[12];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getMatchNumber();
            rowdata[1] = list.get(i).getHome_Team().getTeamID();
            rowdata[2] = list.get(i).getHome_Team().getTeamName();
            rowdata[3] = list.get(i).getAway_Team().getTeamID();
            rowdata[4] = list.get(i).getAway_Team().getTeamName();
            rowdata[5] = list.get(i).getStadiumID().getStadiumID();
            rowdata[6] = list.get(i).getStadiumID().getStadiumName();
            rowdata[7] = list.get(i).getDateMatch();
            rowdata[8] = list.get(i).getTimeMatch();
            rowdata[9] = list.get(i).getStadiumID().getCity();
            rowdata[10] = list.get(i).getStadiumID().getNumberOfSeates();
            rowdata[11] = list.get(i).getStadiumID().getNumberOfParks();

            model.addRow(rowdata);
        }

        jTable1.setModel(model);
    }
    ArrayList<Ticket> listTi;

    public void tableemp(int id) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"TicketId", "Type",
            "Price", "NumberOfTickts"}, 0);
        listTi = ds.SelectTicket(id);
        Object rowdata[] = new Object[4];
        //System.out.println("size" + list.size());
        for (int i = 0; i < listTi.size(); i++) {

            rowdata[0] = listTi.get(i).getTicketId();
            rowdata[1] = listTi.get(i).getType();
            rowdata[2] = listTi.get(i).getPrice();
            rowdata[3] = listTi.get(i).getNumberOfTickts();
            if (i == 0) {
                txtTicketId.setText(listTi.get(i).getTicketId()+ "");
                txtPrice.setText(listTi.get(i).getPrice() + "");

            }else if (i == 1) {
                 txtTicketIdNormal.setText(listTi.get(i).getTicketId()+ "");
                txtPriceNormal.setText(listTi.get(i).getPrice() + "");

            }
            

            model.addRow(rowdata);
        }

        // jTable2.setModel(model);
        // getTickes();
    }
//    public void tableemp() {
//
//        DefaultTableModel model = new DefaultTableModel(new Object[]{"MatchNumber",
//            "Home_TeamName", "Away_TeamName",
//            "StadiumName", "DateMatch",
//            "TimeMatch"}, 0);
//        list = ds.SelectTicketUser();
//
//        Object rowdata[] = new Object[13];
//        //System.out.println("size" + list.size());
//        for (int i = 0; i < list.size(); i++) {
//            rowdata[0] = list.get(i).getTicket().getFootball().getMatchNumber();
//            rowdata[1] = list.get(i).getTicket().getFootball().getHome_Team().getTeamName();
//            rowdata[2] = list.get(i).getTicket().getFootball().getAway_Team().getTeamName();
//            rowdata[3] = list.get(i).getTicket().getFootball().getStadiumID().getStadiumName();
//            rowdata[4] = list.get(i).getTicket().getFootball().getDateMatch();
//            rowdata[5] = list.get(i).getTicket().getFootball().getTimeMatch();
//
//            model.addRow(rowdata);
//        }
//
//        jTable1.setModel(model);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        exit1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtSeatsId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtParksId = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTeanId1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rbVip = new javax.swing.JRadioButton();
        txtTicketId = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rbNormal = new javax.swing.JRadioButton();
        txtTicketIdNormal = new javax.swing.JLabel();
        txtPriceNormal = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        rbFree = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        exit1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 255, 255));
        exit1.setText("X");
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit1MousePressed(evt);
            }
        });
        jPanel2.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 20, -1));

        jLabel13.setFont(new java.awt.Font("Lemonada SemiBold", 0, 24)); // NOI18N
        jLabel13.setText("Football Stadium Ticket System");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 510, 40));

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 22, -1));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ticket Match User");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 360, -1));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 110, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 100));

        jPanel3.setEnabled(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("SeatsId");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 76, -1));

        txtSeatsId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtSeatsId.setForeground(new java.awt.Color(255, 102, 0));
        txtSeatsId.setBorder(null);
        txtSeatsId.setEnabled(false);
        txtSeatsId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSeatsIdFocusGained(evt);
            }
        });
        jPanel3.add(txtSeatsId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, 35));

        jLabel19.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 102, 0));
        jLabel19.setText("ParksId");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 76, -1));

        txtParksId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtParksId.setForeground(new java.awt.Color(255, 102, 0));
        txtParksId.setBorder(null);
        txtParksId.setEnabled(false);
        txtParksId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtParksIdFocusGained(evt);
            }
        });
        jPanel3.add(txtParksId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 120, 35));

        jLabel20.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("MatchTicketId");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 110, -1));

        txtTeanId1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtTeanId1.setForeground(new java.awt.Color(255, 102, 0));
        txtTeanId1.setBorder(null);
        txtTeanId1.setEnabled(false);
        txtTeanId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTeanId1FocusGained(evt);
            }
        });
        jPanel3.add(txtTeanId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 350, 35));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbVip);
        rbVip.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbVip.setText("Vip");
        rbVip.setActionCommand("chNotFree");
        rbVip.setName("rbVip"); // NOI18N
        rbVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVipActionPerformed(evt);
            }
        });
        jPanel1.add(rbVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        txtTicketId.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        txtTicketId.setForeground(new java.awt.Color(255, 102, 0));
        txtTicketId.setText("Ticket Id");
        jPanel1.add(txtTicketId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 40));

        txtPrice.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 102, 0));
        txtPrice.setText("Price");
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 60, 40));

        jLabel23.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 102, 0));
        jLabel23.setText("Ticket Id");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 40));

        jLabel24.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 0));
        jLabel24.setText("Price");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 60, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 160));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbNormal);
        rbNormal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbNormal.setText("Normal");
        rbNormal.setActionCommand("chNotFree");
        rbNormal.setName("rbNotFree"); // NOI18N
        rbNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNormalActionPerformed(evt);
            }
        });
        jPanel4.add(rbNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, -1));

        txtTicketIdNormal.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        txtTicketIdNormal.setForeground(new java.awt.Color(255, 102, 0));
        txtTicketIdNormal.setText("Ticket Id");
        jPanel4.add(txtTicketIdNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 40));

        txtPriceNormal.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        txtPriceNormal.setForeground(new java.awt.Color(255, 102, 0));
        txtPriceNormal.setText("Price");
        jPanel4.add(txtPriceNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 60, 40));

        jLabel27.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 102, 0));
        jLabel27.setText("Ticket Id");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 40));

        jLabel28.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 0));
        jLabel28.setText("Price");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 60, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 190, 150));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 520, 300));

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 102, 0));
        btSave.setText("Add");
        btSave.setEnabled(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 480, 40));

        rbFree.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbFree.setText("Normal");
        rbFree.setActionCommand("cbFree");
        rbFree.setName("rbFree"); // NOI18N
        rbFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFreeActionPerformed(evt);
            }
        });
        getContentPane().add(rbFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(247, 247, 247));
        jTable1.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 510, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        dispose();
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

    private void txtSeatsIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSeatsIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatsIdFocusGained

    private void txtParksIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtParksIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParksIdFocusGained

    private void txtTeanId1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTeanId1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeanId1FocusGained

    private void rbFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFreeActionPerformed
        TypeSelecyed();  // if choose gender this method call
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFreeActionPerformed

    private void rbVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVipActionPerformed
           btSave.setEnabled(true);

        TypeSelecyed();  // if choose gender this method call
    }//GEN-LAST:event_rbVipActionPerformed

    private void rbNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNormalActionPerformed
           TypeSelecyed();  
           btSave.setEnabled(true);
    }//GEN-LAST:event_rbNormalActionPerformed
    MatchFootball matchFootball;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.matchFootball = new MatchFootball();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int selectedrow = jTable1.getSelectedRow();
        matchFootball = list.get(selectedrow);
        tableemp(list.get(selectedrow).getMatchNumber());
        jPanel1.show();
        


    }//GEN-LAST:event_jTable1MouseClicked

//    public void getTickes() {
//
//        txtVipId.setText(listTi.get(0).getTicketId() + "");
//        txtPriceVip.setText(listTi.get(0).getPrice() + "");
//        txtNumberOfTicktsVip.setText(listTi.get(0).getNumberOfTickts() + "");
//        txtNormalId.setText(listTi.get(1).getTicketId() + "");
//        txtPriceNormal.setText(listTi.get(1).getPrice() + "");
//        txtNumberOfTicktsNormal.setText(listTi.get(1).getNumberOfTickts() + "");
//    }
          int upperbound = 1000;
int int_randomSeateID,int_randomPeaksID;
    public  void randomId(){
           Random rand = new Random(); 
      // Setting the upper bound to generate the
      // random numbers in specific range
      // Generating random values from 0 - 24 
      // using nextInt()
       int_randomSeateID = rand.nextInt(upperbound); 
       int_randomPeaksID = rand.nextInt(upperbound); 
      // Generating random using nextDouble 
      // in 0.0 and 1.0 range
    
    }
    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // try {
        try {
            addMatchticket();

            //cleanTextBox();
            tableemp();
            dispose();
            new Home(customere).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " error" + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void exit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exit1MousePressed

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
                new TickesUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbFree;
    private javax.swing.JRadioButton rbNormal;
    private javax.swing.JRadioButton rbVip;
    private javax.swing.JTextField txtParksId;
    private javax.swing.JLabel txtPrice;
    private javax.swing.JLabel txtPriceNormal;
    private javax.swing.JTextField txtSeatsId;
    private javax.swing.JTextField txtTeanId1;
    private javax.swing.JLabel txtTicketId;
    private javax.swing.JLabel txtTicketIdNormal;
    // End of variables declaration//GEN-END:variables

    private Object Home() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
