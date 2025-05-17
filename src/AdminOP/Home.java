/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminOP;

import AdminOP.MainApp;
import AdminOP.TeamsOp;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.Customer;
import com.mycompany.footballstadiumticketsystem.model.Invoice;
import com.mycompany.footballstadiumticketsystem.model.Matchticket;
import com.mycompany.footballstadiumticketsystem.model.PaymentCach;
import com.mycompany.footballstadiumticketsystem.model.PaymentCard;
import com.mycompany.footballstadiumticketsystem.model.Services;
import com.mycompany.footballstadiumticketsystem.model.Ticket;
import com.mycompany.footballstadiumticketsystem.model.TotelPayment;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KeepToo
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    Customer customer = new Customer();
    double totel;

    public Home(Customer c) {
        initComponents();
        this.customer = c;
        this.id = c.getId();
        TxtName.setText(TxtName.getText() + customer.getFname() + " " + customer.getLname());
        txtPhone.setText(txtPhone.getText() + " " + customer.getPhone());
        txtAddress.setText(txtAddress.getText() + " " + customer.getAddress());
        txtGender.setText(txtGender.getText() + " " + customer.getGender());
        txtUserName.setText(txtUserName.getText() + " " + customer.getUserName());

        ds = new DataService();
        tableemp();
        jpServices.hide();
        lbTotel.setText(totel + "");
        payment = ds.SelectTotelPayment(customer.getId());
        PayCard.setText(payment.getPayCard() + "");
        PayCach.setText(payment.getPayCach() + "");
    }
    TotelPayment payment = new TotelPayment();

    DataService ds;

    private Home() {
    }
    ArrayList<Matchticket> list;
    ArrayList<Invoice> listInvoices;

    public void tableemp() {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"MatchTicketId", "MatchNumber",
            "Home_TeamName", "Away_TeamName",
            "TicketId", "Type", "Price", "SeatesId", "ParksId", "PriceService"}, 0);
        list = ds.SelectMatchticket(customer.getId());

        Object rowdata[] = new Object[10];
        //System.out.println("size" + list.size());
        for (int i = 0; i < list.size(); i++) {
            rowdata[0] = list.get(i).getMatchTicketId();
            rowdata[1] = list.get(i).getTicket().getFootball().getMatchNumber();
            rowdata[2] = list.get(i).getTicket().getFootball().getHome_Team().getTeamName();
            rowdata[3] = list.get(i).getTicket().getFootball().getAway_Team().getTeamName();
            rowdata[4] = list.get(i).getTicket().getTicketId();
            rowdata[5] = list.get(i).getTicket().getType();
            rowdata[6] = list.get(i).getTicket().getPrice();
            rowdata[7] = list.get(i).getSeatesId();

            rowdata[8] = list.get(i).getParksId();
            rowdata[9] = list.get(i).getPriceServise();
            totel += list.get(i).getPriceServise() + list.get(i).getTicket().getPrice();

            model.addRow(rowdata);
        }

        jTable1.setModel(model);
    }

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

    ArrayList<PaymentCach> listPaymentCach;

    public void tablPaymentCach(int mid) {

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

        jTable6.setModel(model);
    }
    ArrayList<PaymentCard> listCard;

    public void tablePaymentCard(int mid) {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"PaymentId", "DatePay", "Amount", "CardNumber", "CardName"}, 0);
        listCard = ds.SelectPaymentCard(mid);

        Object rowdata[] = new Object[5];
        //System.out.println("size" + list.size());
        for (int i = 0; i < listCard.size(); i++) {
            rowdata[0] = listCard.get(i).getPaymentId();
            rowdata[1] = listCard.get(i).getDatePay();
            rowdata[2] = listCard.get(i).getAmount();
            rowdata[3] = listCard.get(i).getCardNumber();
            rowdata[4] = listCard.get(i).getCardName();
            model.addRow(rowdata);
        }

        jTable5.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Button1 = new javax.swing.JPanel();
        Indicator1 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JLabel();
        kdkdk = new javax.swing.JPanel();
        Indicator2 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JLabel();
        Button3 = new javax.swing.JPanel();
        Indicator3 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JLabel();
        Button4 = new javax.swing.JPanel();
        Indicator4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtGender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TxtName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbTotel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        PayCard = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtStadiumName = new javax.swing.JLabel();
        txtStdimId = new javax.swing.JLabel();
        txtCity1 = new javax.swing.JLabel();
        txtNumberSteas1 = new javax.swing.JLabel();
        txtNumberOfParks = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtAwayTeamLoction = new javax.swing.JLabel();
        txtAwayTeamName = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtAwTeDateOfEstablishment = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txtTimeMatch = new javax.swing.JLabel();
        txtDateMatch = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        txtHomeTeamLoction = new javax.swing.JLabel();
        txtHomeTeamName = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtHoTeDateOfEstablishment = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        PayCach = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpServices = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jpServices2 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jpServices1 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button1.setBackground(new java.awt.Color(255, 255, 255));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button1MouseExited(evt);
            }
        });

        Indicator1.setBackground(new java.awt.Color(204, 0, 204));
        Indicator1.setOpaque(false);

        javax.swing.GroupLayout Indicator1Layout = new javax.swing.GroupLayout(Indicator1);
        Indicator1.setLayout(Indicator1Layout);
        Indicator1Layout.setHorizontalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator1Layout.setVerticalGroup(
            Indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(181, 77, 180));
        txtUserName.setText("UserName :");

        javax.swing.GroupLayout Button1Layout = new javax.swing.GroupLayout(Button1);
        Button1.setLayout(Button1Layout);
        Button1Layout.setHorizontalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button1Layout.createSequentialGroup()
                .addComponent(Indicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtUserName)
                .addGap(0, 107, Short.MAX_VALUE))
        );
        Button1Layout.setVerticalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Button1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 232, -1));

        kdkdk.setBackground(new java.awt.Color(255, 255, 255));
        kdkdk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kdkdkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kdkdkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kdkdkMouseExited(evt);
            }
        });
        kdkdk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Indicator2.setBackground(new java.awt.Color(204, 0, 204));
        Indicator2.setOpaque(false);

        javax.swing.GroupLayout Indicator2Layout = new javax.swing.GroupLayout(Indicator2);
        Indicator2.setLayout(Indicator2Layout);
        Indicator2Layout.setHorizontalGroup(
            Indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator2Layout.setVerticalGroup(
            Indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        kdkdk.add(Indicator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 36));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(96, 83, 150));
        txtPhone.setText("Phone : ");
        kdkdk.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 6, -1, 24));

        jPanel1.add(kdkdk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 227, 232, -1));

        Button3.setBackground(new java.awt.Color(255, 255, 255));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button3MouseExited(evt);
            }
        });
        Button3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Indicator3.setBackground(new java.awt.Color(204, 0, 204));
        Indicator3.setOpaque(false);

        javax.swing.GroupLayout Indicator3Layout = new javax.swing.GroupLayout(Indicator3);
        Indicator3.setLayout(Indicator3Layout);
        Indicator3Layout.setHorizontalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator3Layout.setVerticalGroup(
            Indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        Button3.add(Indicator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 36));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(96, 83, 150));
        txtAddress.setText("Address :");
        Button3.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 6, -1, 24));

        jPanel1.add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 279, 232, -1));

        Button4.setBackground(new java.awt.Color(255, 255, 255));
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button4MouseExited(evt);
            }
        });

        Indicator4.setBackground(new java.awt.Color(204, 0, 204));
        Indicator4.setOpaque(false);

        javax.swing.GroupLayout Indicator4Layout = new javax.swing.GroupLayout(Indicator4);
        Indicator4.setLayout(Indicator4Layout);
        Indicator4Layout.setHorizontalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        Indicator4Layout.setVerticalGroup(
            Indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Button4Layout = new javax.swing.GroupLayout(Button4);
        Button4.setLayout(Button4Layout);
        Button4Layout.setHorizontalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button4Layout.createSequentialGroup()
                .addComponent(Indicator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 224, Short.MAX_VALUE))
        );
        Button4Layout.setVerticalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Indicator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 232, -1));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 39, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/fallon.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 57, -1, -1));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel13.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        txtGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGender.setForeground(new java.awt.Color(96, 83, 150));
        txtGender.setText("Gender");
        jPanel1.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 24));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 83, 150));
        jLabel4.setText("Exit");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 90, 24));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 410));

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

        TxtName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TxtName.setForeground(new java.awt.Color(96, 83, 150));
        TxtName.setText("Welcome  ");
        jPanel2.add(TxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, 270, 37));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTotel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotel.setForeground(new java.awt.Color(96, 83, 150));
        lbTotel.setText("500");
        jPanel3.add(lbTotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel11.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(96, 83, 150));
        jLabel7.setText("Total");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 41));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PayCard.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PayCard.setForeground(new java.awt.Color(96, 83, 150));
        PayCard.setText("$2000");
        jPanel5.add(PayCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel12.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 10));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 83, 150));
        jLabel13.setText("$2000");
        jPanel16.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel20.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 10));

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 140, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(96, 83, 150));
        jLabel12.setText("Payment Cach All");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 130, 30));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStadiumName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStadiumName.setForeground(new java.awt.Color(255, 0, 51));
        txtStadiumName.setText("*");
        jPanel7.add(txtStadiumName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 220, 20));

        txtStdimId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtStdimId.setForeground(new java.awt.Color(96, 83, 150));
        txtStdimId.setText("Oscar");
        jPanel7.add(txtStdimId, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 60, -1));

        txtCity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCity1.setForeground(new java.awt.Color(255, 0, 0));
        txtCity1.setText("Oscar");
        jPanel7.add(txtCity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        txtNumberSteas1.setForeground(new java.awt.Color(96, 83, 150));
        jPanel7.add(txtNumberSteas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, 20));

        txtNumberOfParks.setForeground(new java.awt.Color(204, 0, 0));
        jPanel7.add(txtNumberOfParks, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 80, 20));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 90));

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAwayTeamLoction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAwayTeamLoction.setForeground(new java.awt.Color(204, 0, 0));
        jPanel18.add(txtAwayTeamLoction, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, 30));

        txtAwayTeamName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAwayTeamName.setForeground(new java.awt.Color(204, 0, 51));
        txtAwayTeamName.setText("Name");
        jPanel18.add(txtAwayTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 83, 150));
        jLabel22.setText("Loction");
        jPanel18.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 130, -1));

        txtAwTeDateOfEstablishment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAwTeDateOfEstablishment.setForeground(new java.awt.Color(204, 0, 0));
        jPanel18.add(txtAwTeDateOfEstablishment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(96, 83, 150));
        jLabel26.setText("Home Teams");
        jPanel18.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(96, 83, 150));
        jLabel27.setText("DateOfEstablishment :");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));

        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 350, 110));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTimeMatch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimeMatch.setForeground(new java.awt.Color(204, 0, 0));
        jPanel17.add(txtTimeMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, 30));

        txtDateMatch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDateMatch.setForeground(new java.awt.Color(204, 0, 0));
        jPanel17.add(txtDateMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(96, 83, 150));
        jLabel17.setText("Time Match :");
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 80, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(96, 83, 150));
        jLabel25.setText("Date Match :");
        jPanel17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel6.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 350, 60));

        jButton1.setFont(new java.awt.Font("Lemonada Light", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Save File Text");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 350, 30));

        jButton2.setFont(new java.awt.Font("Lemonada Light", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Save File Text");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 350, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Data Read of File");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 110, 24));

        jButton3.setFont(new java.awt.Font("Lemonada Light", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 51));
        jButton3.setText("Open File Text");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 350, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(96, 83, 150));
        jLabel19.setText("Details Football Match");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 100, -1));

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHomeTeamLoction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHomeTeamLoction.setForeground(new java.awt.Color(204, 0, 51));
        jPanel25.add(txtHomeTeamLoction, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 150, 30));

        txtHomeTeamName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHomeTeamName.setForeground(new java.awt.Color(204, 0, 51));
        txtHomeTeamName.setText("Name");
        jPanel25.add(txtHomeTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(96, 83, 150));
        jLabel28.setText("Loction");
        jPanel25.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        txtHoTeDateOfEstablishment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHoTeDateOfEstablishment.setForeground(new java.awt.Color(204, 0, 0));
        jPanel25.add(txtHoTeDateOfEstablishment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(96, 83, 150));
        jLabel29.setText("Home Teams");
        jPanel25.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(96, 83, 150));
        jLabel30.setText("DateOfEstablishment :");
        jPanel25.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));

        jPanel6.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 350, 110));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 350, 167));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 350, 770));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 750, 210));

        jPanel8.setBackground(new java.awt.Color(96, 83, 150));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("X");
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        jPanel8.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 0, 20, 30));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 180, -1));

        jLabel14.setFont(new java.awt.Font("Lemonada SemiBold", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("View Data User");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 230, 40));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PayCach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PayCach.setForeground(new java.awt.Color(96, 83, 150));
        PayCach.setText("$2000");
        jPanel21.add(PayCach, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 50, -1));

        jPanel22.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 10));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(96, 83, 150));
        jLabel23.setText("$2000");
        jPanel23.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel24.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 10));

        jPanel21.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 140, 80));

        jPanel2.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 130, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(96, 83, 150));
        jLabel24.setText("Payment Card All");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, 30));

        jpServices.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpServices.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 660, -1));

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
        jScrollPane2.setViewportView(jTable2);

        jpServices.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 730, 120));

        jTabbedPane1.addTab("Invoice", jpServices);

        jpServices2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpServices2.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 660, -1));

        jScrollPane7.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable6.setGridColor(new java.awt.Color(247, 247, 247));
        jTable6.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane7.setViewportView(jTable6);

        jpServices2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 130));

        jTabbedPane1.addTab("Payment Cach", jpServices2);

        jpServices1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpServices1.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 660, -1));

        jScrollPane6.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setGridColor(new java.awt.Color(247, 247, 247));
        jTable5.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane6.setViewportView(jTable5);

        jpServices1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 730, 130));

        jTabbedPane1.addTab("Payment Card", jpServices1);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 750, 230));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Football Stadium Ticket System");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 550, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1120, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        // TODO add your handling code here:
        onClick(Button1);
        onLeaveClick(kdkdk);
        onLeaveClick(Button3);
        onLeaveClick(Button4);

        //indicators
        Indicator1.setOpaque(true);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);

    }//GEN-LAST:event_Button1MouseClicked

    private void kdkdkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kdkdkMouseClicked
        // TODO add your handling code here:
        onClick(kdkdk);
        onLeaveClick(Button1);
        onLeaveClick(Button3);
        onLeaveClick(Button4);

        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(true);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(false);
    }//GEN-LAST:event_kdkdkMouseClicked

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseClicked
        // TODO add your handling code here:
        onClick(Button3);
        onLeaveClick(kdkdk);
        onLeaveClick(Button1);
        onLeaveClick(Button4);

        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(true);
        Indicator4.setOpaque(false);
    }//GEN-LAST:event_Button3MouseClicked

    private void Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseClicked
        // TODO add your handling code here:
        onClick(Button4);
        onLeaveClick(kdkdk);
        onLeaveClick(Button3);
        onLeaveClick(Button1);
        //indicators
        Indicator1.setOpaque(false);
        Indicator2.setOpaque(false);
        Indicator3.setOpaque(false);
        Indicator4.setOpaque(true);
    }//GEN-LAST:event_Button4MouseClicked

    private void Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_Button1MouseEntered

    private void kdkdkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kdkdkMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_kdkdkMouseEntered

    private void Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_Button3MouseEntered

    private void Button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseEntered
        // TODO add your handling code here:]

    }//GEN-LAST:event_Button4MouseEntered

    private void Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button1MouseExited

    private void kdkdkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kdkdkMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_kdkdkMouseExited

    private void Button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button3MouseExited

    private void Button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button4MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    int id;
    int matchTicketId;
    int selectedrow;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        selectedrow = jTable1.getSelectedRow();
        txtHomeTeamName.setText(list.get(selectedrow).getTicket().getFootball().getHome_Team().getTeamName());
        txtHoTeDateOfEstablishment.setText(list.get(selectedrow).getTicket().getFootball().getHome_Team().getDateOfEstablishment() + "");
        txtHomeTeamLoction.setText(list.get(selectedrow).getTicket().getFootball().getHome_Team().getLoaction());
        txtAwayTeamName.setText(list.get(selectedrow).getTicket().getFootball().getAway_Team().getTeamName());
        txtAwTeDateOfEstablishment.setText(list.get(selectedrow).getTicket().getFootball().getAway_Team().getDateOfEstablishment() + "");
        txtAwayTeamLoction.setText(list.get(selectedrow).getTicket().getFootball().getAway_Team().getLoaction());
        txtDateMatch.setText(list.get(selectedrow).getTicket().getFootball().getDateMatch() + "");
        txtTimeMatch.setText(list.get(selectedrow).getTicket().getFootball().getTimeMatch() + "");
        txtStdimId.setText(list.get(selectedrow).getTicket().getFootball().getStadiumID().getStadiumID() + "");
        txtStadiumName.setText(list.get(selectedrow).getTicket().getFootball().getStadiumID().getStadiumName() + "");
        txtCity1.setText(list.get(selectedrow).getTicket().getFootball().getStadiumID().getCity() + "");
        txtNumberSteas1.setText(list.get(selectedrow).getTicket().getFootball().getStadiumID().getNumberOfSeates() + "");
        txtNumberOfParks.setText(+list.get(selectedrow).getTicket().getFootball().getStadiumID().getNumberOfParks() + "");
        matchTicketId = (list.get(selectedrow).getMatchTicketId());
        tableemp(list.get(selectedrow).getMatchTicketId());
        tablPaymentCach(list.get(selectedrow).getMatchTicketId());
        tablePaymentCard(list.get(selectedrow).getMatchTicketId());
        matchTicketId = (list.get(selectedrow).getMatchTicketId());
        jpServices.show();
        //txtServiceName.setText(model.getValueAt(selectedrow, 1).toString());
        //  txtPrice.setText(model.getValueAt(selectedrow, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        MainApp ma = new MainApp();
        ma.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            jTextArea1.setLineWrap(true);

            jTextArea1.setText(jTextArea1.getText() + " Football Stadium Ticket System ");
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + "MatchTicket Id :  " + list.get(selectedrow).getMatchTicketId());
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + "Price :  " + list.get(selectedrow).getPriceServise());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " SeatesId :  " + list.get(selectedrow).getSeatesId());
            jTextArea1.append("\n");
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " Team Name :  " + list.get(selectedrow).getTicket().getFootball().getHome_Team().getTeamName());
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " Team Name :  " + list.get(selectedrow).getTicket().getFootball().getAway_Team().getTeamName());
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " Stadium  Name :  " + list.get(selectedrow).getTicket().getFootball().getStadiumID().getStadiumName());
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " Date Match   :  " + list.get(selectedrow).getTicket().getFootball().getDateMatch());
            jTextArea1.append("\n");
            jTextArea1.setText(jTextArea1.getText() + " " + " Time  Match :  " + list.get(selectedrow).getTicket().getFootball().getTimeMatch());
            jTextArea1.append("\n");
            jTextArea1.append("\n");

            FileOutputStream fos = null;
            String fileData = jTextArea1.getText();
            fos = new FileOutputStream(txtUserName.getText() + ".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
            FileWriter myWriter = null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        doSaveFile();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            jTextArea1.setLineWrap(true);
            for (int i = 0; i < list.size(); i++) {

                jTextArea1.setText(jTextArea1.getText() + " Football Stadium Ticket System ");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "MatchTicket Id :  " + list.get(i).getMatchTicketId());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + "Price :  " + list.get(i).getPriceServise());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " SeatesId :  " + list.get(i).getSeatesId());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Team Name :  " + list.get(i).getTicket().getFootball().getHome_Team().getTeamName());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Team Name :  " + list.get(i).getTicket().getFootball().getAway_Team().getTeamName());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Stadium  Name :  " + list.get(i).getTicket().getFootball().getStadiumID().getStadiumName());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Date Match   :  " + list.get(i).getTicket().getFootball().getDateMatch());
                jTextArea1.append("\n");
                jTextArea1.setText(jTextArea1.getText() + " " + " Time  Match :  " + list.get(i).getTicket().getFootball().getTimeMatch());
                jTextArea1.append("\n");
                jTextArea1.append("\n");
            }
            FileOutputStream fos = null;
            String fileData = jTextArea1.getText();
            fos = new FileOutputStream(txtUserName.getText() + ".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
            FileWriter myWriter = null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        doSaveFile();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void doSaveFile() {
        k = new JFileChooser();
        int result;
        result = k.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // We'll be making a mytmp.txt file, write in there, then move it to
            // the selected
            // file. This takes care of clearing that file, should there be
            // content in it.
            File targetFile = k.getSelectedFile();

            try {
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }

                FileWriter fw = new FileWriter(targetFile + ".txt");

                fw.write(jTextArea1.getText());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        doOpenFile();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyTyped
    private void doOpenFile() {
        k = new JFileChooser();
        jTextArea1.setText("");
        int result = k.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path path = k.getSelectedFile().toPath();

            try {
                String contentString = "";

                for (String s : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                    contentString += s;
                }

                jTextArea1.setText(contentString);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    JFileChooser k;
    int xx, xy;

    //bad idea
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(205, 136, 205));
    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(Color.white);
    }

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

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button1;
    private javax.swing.JPanel Button3;
    private javax.swing.JPanel Button4;
    private javax.swing.JPanel Indicator1;
    private javax.swing.JPanel Indicator2;
    private javax.swing.JPanel Indicator3;
    private javax.swing.JPanel Indicator4;
    private javax.swing.JLabel PayCach;
    private javax.swing.JLabel PayCard;
    private javax.swing.JLabel TxtName;
    private javax.swing.JLabel btn_close;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jpServices;
    private javax.swing.JPanel jpServices1;
    private javax.swing.JPanel jpServices2;
    private javax.swing.JPanel kdkdk;
    private javax.swing.JLabel lbTotel;
    private javax.swing.JLabel txtAddress;
    private javax.swing.JLabel txtAwTeDateOfEstablishment;
    private javax.swing.JLabel txtAwayTeamLoction;
    private javax.swing.JLabel txtAwayTeamName;
    private javax.swing.JLabel txtCity1;
    private javax.swing.JLabel txtDateMatch;
    private javax.swing.JLabel txtGender;
    private javax.swing.JLabel txtHoTeDateOfEstablishment;
    private javax.swing.JLabel txtHomeTeamLoction;
    private javax.swing.JLabel txtHomeTeamName;
    private javax.swing.JLabel txtNumberOfParks;
    private javax.swing.JLabel txtNumberSteas1;
    private javax.swing.JLabel txtPhone;
    private javax.swing.JLabel txtStadiumName;
    private javax.swing.JLabel txtStdimId;
    private javax.swing.JLabel txtTimeMatch;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables
}
