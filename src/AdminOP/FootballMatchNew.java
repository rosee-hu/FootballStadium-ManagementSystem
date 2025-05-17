/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminOP;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mycompany.footballstadiumticketsystem.DataService;
import com.mycompany.footballstadiumticketsystem.model.MatchFootball;
import com.mycompany.footballstadiumticketsystem.model.Stadiums;
import com.mycompany.footballstadiumticketsystem.model.Teams;
import com.mycompany.footballstadiumticketsystem.model.Ticket;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FootballMatchNew extends javax.swing.JFrame {

    /**
     * Creates new form FootballMatchNew
     */
    public FootballMatchNew() {
        initComponents();
        ds = new DataService();
        txtNumberOfTicktsNormal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtNumberOfTicktsVip.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtPriceVip.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtPriceNormal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
    }

    int op = 1;

    public FootballMatchNew(MatchFootball football) {
        initComponents();
        ds = new DataService();
        op = 2;
        txtNumberOfTicktsNormal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtNumberOfTicktsVip.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtPriceVip.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        txtPriceNormal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
        btChooseHomeTeam.setText("Update");
        txtAwayTeamId.setText(football.getAway_Team().getTeamID() + "");
        txtAwayTeamName1.setText(football.getAway_Team().getTeamName());
        txtCity.setText(football.getStadiumID().getCity());
        txtHomeTeamId.setText(football.getHome_Team().getTeamID() + "");
        txtHomeTeamName.setText(football.getHome_Team().getTeamName());
        txtStadiumId.setText(football.getStadiumID().getStadiumID() + "");
        txtStadiumName.setText(football.getStadiumID().getStadiumName());
        try {

            String dateValue = (football.getDateMatch().toString());
// Your column Name
            if (dateValue.equals("")) {

            } else {
                java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateValue);

                txtDateTime.setDate(date);
            }

        } catch (ParseException ex) {
            Logger.getLogger(TeamsOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNumberSeates.setText(football.getStadiumID().getNumberOfSeates() + "");
        txtNumberParks.setText(football.getStadiumID().getNumberOfParks() + "");

        MatchNumber.setText(football.getMatchNumber() + "");
        tableemp(football.getMatchNumber());
        txtVipId.setText(listTi.get(0).getTicketId() + "");
        txtPriceVip.setText(listTi.get(0).getPrice() + "");
        txtNumberOfTicktsVip.setText(listTi.get(0).getNumberOfTickts() + "");
        txtNormalId.setText(listTi.get(1).getTicketId() + "");
        txtPriceNormal.setText(listTi.get(1).getPrice() + "");
        txtNumberOfTicktsNormal.setText(listTi.get(1).getNumberOfTickts() + "");

    }
    DataService ds;
    MatchFootball football = new MatchFootball();
    Teams homeTeams = new Teams();
    Teams awayTeams = new Teams();

    Stadiums stadiums = new Stadiums();

    Ticket ticketVip = new Ticket();
    Ticket ticketNormal = new Ticket();

    String typeVip = "Vip", typeNormal = "Normal";

    public void addMachFootball() throws ParseException {
        int result = 0;

        if (txtHomeTeamId.getText().equals("")
                || txtHomeTeamName.getText().equals("")
                || txtAwayTeamId.getText().equals("")
                || txtPriceVip.getText().equals("")
                || txtStadiumId.getText().equals("")
                || txtStadiumName.getText().equals("")
                || txtDateTime.equals("")
                || txtTime.getText().equals("")
                || txtPriceVip.getText().equals("")
                || txtPriceNormal.getText().equals("")
                || txtNumberOfTicktsVip.getText().equals("")
                || txtNumberOfTicktsNormal.getText().equals("")
                || typeVip.equals("") || typeNormal.equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            homeTeams.setTeamID(Integer.parseInt(txtHomeTeamId.getText()));

            awayTeams.setTeamID(Integer.parseInt(txtAwayTeamId.getText()));
            stadiums.setStadiumID(Integer.parseInt(txtStadiumId.getText()));
            football.setHome_Team(homeTeams);
            football.setAway_Team(awayTeams);
            football.setStadiumID(stadiums);
            football.setDateMach(new java.sql.Date(txtDateTime.getDate().getTime()));

 SimpleDateFormat format = new SimpleDateFormat("hh:m"); //if 24 hour format

            java.sql.Time timeValue = new java.sql.Time(format.parse(txtTime.getText()).getTime());

            football.setTimeMatch(timeValue);            ticketVip.setType(typeVip);
            ticketVip.setPrice(Double.parseDouble(txtPriceVip.getText()));
            ticketVip.setNumberOfTickts(Integer.parseInt(txtNumberOfTicktsVip.getText()));

            ticketNormal.setType(typeNormal);
            ticketNormal.setPrice(Double.parseDouble(txtPriceNormal.getText()));
            ticketNormal.setNumberOfTickts(Integer.parseInt(txtNumberOfTicktsNormal.getText()));
            football.setStatus(1);
            try {
                if (ds.InsertMachFootball(football) == 1) {

                    ds.InsertTicket(ticketVip);
                    ds.InsertTicket(ticketNormal);

                    JOptionPane.showMessageDialog(this, "Records inserted successfully.", "Entry Error", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Records insertion failed.", "Entry Error", 1);
                }

                //   con.close();
            } catch (SQLException ex) {
                Logger.getLogger(FootballMatchNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateData() throws ParseException {

        //actionGender().equals("not selected")
        if (txtHomeTeamId.getText().equals("")
                || txtHomeTeamName.getText().equals("")
                || txtAwayTeamId.getText().equals("")
                || txtPriceVip.getText().equals("")
                || txtStadiumId.getText().equals("")
                || txtStadiumName.getText().equals("")
                || txtDateTime.equals("")
                || txtTime.getText().equals("")
                || txtPriceVip.getText().equals("")
                || txtPriceNormal.getText().equals("")
                || txtNumberOfTicktsVip.getText().equals("")
                || txtNumberOfTicktsNormal.getText().equals("")
                || typeVip.equals("") || typeNormal.equals("")) {
            JOptionPane.showMessageDialog(this, "Please make sure that none of the fields are blank.", "Entry Error", 1);
        } else {
            homeTeams.setTeamID(Integer.parseInt(txtHomeTeamId.getText()));

            awayTeams.setTeamID(Integer.parseInt(txtAwayTeamId.getText()));
            stadiums.setStadiumID(Integer.parseInt(txtStadiumId.getText()));
            football.setHome_Team(homeTeams);
            football.setAway_Team(awayTeams);
            football.setStadiumID(stadiums);
            football.setDateMach(new java.sql.Date(txtDateTime.getDate().getTime()));
            SimpleDateFormat format = new SimpleDateFormat("hh:mm"); //if 24 hour format

            java.sql.Time timeValue = new java.sql.Time(format.parse(txtTime.getText()).getTime());

            football.setTimeMatch(timeValue);

            ticketVip.setType(typeVip);
            ticketVip.setPrice(Double.parseDouble(txtPriceVip.getText()));
            ticketVip.setNumberOfTickts(Integer.parseInt(txtNumberOfTicktsVip.getText()));

            ticketNormal.setType(typeNormal);
            ticketNormal.setPrice(Double.parseDouble(txtPriceNormal.getText()));
            ticketNormal.setNumberOfTickts(Integer.parseInt(txtNumberOfTicktsNormal.getText()));
            football.setStatus(1);

            try {
                ds.updateMachFootball(Integer.valueOf(MatchNumber.getText()), football);
                ds.updateTicket(Integer.valueOf(txtVipId.getText()), ticketVip);
                ds.updateTicket(Integer.valueOf(txtNormalId.getText()), ticketNormal);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, " " + e.getMessage(), "Entry Error", 1);

            }

        }

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

            model.addRow(rowdata);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtStadiumId = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtStadiumName = new javax.swing.JTextField();
        btStaduimChosse = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtDateTime = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtNumberSeates = new javax.swing.JTextField();
        btSave3 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtNumberParks = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        MatchNumber = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtAwayTeamId = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btChooesAwayTeam = new javax.swing.JButton();
        txtTeanId5 = new javax.swing.JTextField();
        txtAwayTeamName1 = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        btSave4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbVip = new javax.swing.JRadioButton();
        txtPriceVip = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtNumberOfTicktsVip = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtVipId = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rbNormal = new javax.swing.JRadioButton();
        k = new javax.swing.JLabel();
        txtPriceNormal = new javax.swing.JTextField();
        txtNumberOfTicktsNormal = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNormalId = new javax.swing.JTextField();
        k1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtHomeTeamId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHomeTeamName = new javax.swing.JTextField();
        btChooseHomeTeam = new javax.swing.JButton();

        timePicker1.setDisplayText(txtTime);

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
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 510, 40));

        exit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 22, -1));

        jLabel15.setFont(new java.awt.Font("Lemonada SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Football Match");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 340, -1));
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 100));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 80));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("StadiumId");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 76, -1));

        txtStadiumId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtStadiumId.setBorder(null);
        txtStadiumId.setEnabled(false);
        txtStadiumId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStadiumIdFocusGained(evt);
            }
        });
        jPanel4.add(txtStadiumId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 45, 35));

        jLabel21.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 102, 0));
        jLabel21.setText("Number Of Parks");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 110, 35));

        txtStadiumName.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtStadiumName.setBorder(null);
        txtStadiumName.setEnabled(false);
        txtStadiumName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStadiumNameFocusGained(evt);
            }
        });
        jPanel4.add(txtStadiumName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 251, 35));

        btStaduimChosse.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btStaduimChosse.setForeground(new java.awt.Color(255, 102, 0));
        btStaduimChosse.setText("Choose");
        btStaduimChosse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStaduimChosseActionPerformed(evt);
            }
        });
        jPanel4.add(btStaduimChosse, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 111, -1));

        jLabel22.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 102, 0));
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 127, -1, -1));

        txtTime.setBorder(null);
        txtTime.setEnabled(false);
        txtTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimeFocusGained(evt);
            }
        });
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });
        jPanel4.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 190, 35));

        jLabel26.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 102, 0));
        jLabel26.setText("Stadium Name");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 119, 30));

        jLabel27.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 102, 0));
        jLabel27.setText("Date ");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 35));

        txtCity.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtCity.setBorder(null);
        txtCity.setEnabled(false);
        txtCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCityFocusGained(evt);
            }
        });
        jPanel4.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 100, 35));

        txtDateTime.setForeground(new java.awt.Color(255, 255, 255));
        txtDateTime.setDateFormatString("dd‏/MM‏/y ");
        jPanel4.add(txtDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 240, 35));

        jLabel28.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 0));
        jLabel28.setText("City");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 50, 35));

        jLabel29.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 102, 0));
        jLabel29.setText("Time");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 40, 35));

        txtNumberSeates.setEditable(false);
        txtNumberSeates.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtNumberSeates.setBorder(null);
        txtNumberSeates.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumberSeatesFocusGained(evt);
            }
        });
        jPanel4.add(txtNumberSeates, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 60, 35));

        btSave3.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave3.setForeground(new java.awt.Color(255, 102, 0));
        btSave3.setText("Sava");
        btSave3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSave3ActionPerformed(evt);
            }
        });
        jPanel4.add(btSave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 30, -1));

        jLabel30.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 102, 0));
        jLabel30.setText("Number Of Seats");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 105, 35));

        txtNumberParks.setEditable(false);
        txtNumberParks.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtNumberParks.setBorder(null);
        txtNumberParks.setEnabled(false);
        txtNumberParks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumberParksFocusGained(evt);
            }
        });
        jPanel4.add(txtNumberParks, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 60, 35));

        jLabel35.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 102, 0));
        jLabel35.setText("Match Number");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 90, 20));

        MatchNumber.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        MatchNumber.setBorder(null);
        MatchNumber.setEnabled(false);
        MatchNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MatchNumberFocusGained(evt);
            }
        });
        jPanel4.add(MatchNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 130, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel23.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 102, 0));
        jLabel23.setText("Team Two");

        txtAwayTeamId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtAwayTeamId.setBorder(null);
        txtAwayTeamId.setEnabled(false);
        txtAwayTeamId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAwayTeamIdFocusGained(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 0));
        jLabel24.setText("Team Name");

        btChooesAwayTeam.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btChooesAwayTeam.setForeground(new java.awt.Color(255, 102, 0));
        btChooesAwayTeam.setText("Choose");
        btChooesAwayTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChooesAwayTeamActionPerformed(evt);
            }
        });

        txtTeanId5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtTeanId5.setForeground(new java.awt.Color(255, 102, 0));
        txtTeanId5.setBorder(null);

        txtAwayTeamName1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtAwayTeamName1.setBorder(null);
        txtAwayTeamName1.setEnabled(false);
        txtAwayTeamName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAwayTeamName1FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAwayTeamId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269)
                .addComponent(btChooesAwayTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 93, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(txtTeanId5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(243, Short.MAX_VALUE)
                    .addComponent(txtAwayTeamName1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(206, 206, 206)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(btChooesAwayTeam)
                            .addGap(58, 58, 58))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAwayTeamId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtTeanId5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(txtAwayTeamName1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 700, 60));

        btSave.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave.setForeground(new java.awt.Color(255, 102, 0));
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 315, -1));

        btSave4.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btSave4.setForeground(new java.awt.Color(255, 102, 0));
        btSave4.setText("Cancel");
        btSave4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSave4ActionPerformed(evt);
            }
        });
        getContentPane().add(btSave4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 270, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbVip.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbVip.setSelected(true);
        rbVip.setText("Vip");
        rbVip.setActionCommand("chNotFree");
        rbVip.setEnabled(false);
        rbVip.setName("rbVip"); // NOI18N
        rbVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVipActionPerformed(evt);
            }
        });
        jPanel1.add(rbVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        txtPriceVip.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPriceVip.setBorder(null);
        txtPriceVip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceVipFocusGained(evt);
            }
        });
        jPanel1.add(txtPriceVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 130, 30));

        jLabel32.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 102, 0));
        jLabel32.setText("Price");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, 20));

        txtNumberOfTicktsVip.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtNumberOfTicktsVip.setBorder(null);
        txtNumberOfTicktsVip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumberOfTicktsVipFocusGained(evt);
            }
        });
        jPanel1.add(txtNumberOfTicktsVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 130, 30));

        jLabel33.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 102, 0));
        jLabel33.setText("NumberOfTickts");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 20));

        txtVipId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtVipId.setBorder(null);
        txtVipId.setEnabled(false);
        txtVipId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtVipIdFocusGained(evt);
            }
        });
        jPanel1.add(txtVipId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 30));

        jLabel34.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 102, 0));
        jLabel34.setText("Id");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 330, 170));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbNormal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbNormal.setSelected(true);
        rbNormal.setText("Normal");
        rbNormal.setActionCommand("chNotFree");
        rbNormal.setEnabled(false);
        rbNormal.setName("rbNotFree"); // NOI18N
        rbNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNormalActionPerformed(evt);
            }
        });
        jPanel6.add(rbNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, -1));

        k.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        k.setForeground(new java.awt.Color(255, 102, 0));
        k.setText("Price");
        jPanel6.add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, 20));

        txtPriceNormal.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtPriceNormal.setBorder(null);
        txtPriceNormal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceNormalFocusGained(evt);
            }
        });
        jPanel6.add(txtPriceNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 120, 35));

        txtNumberOfTicktsNormal.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtNumberOfTicktsNormal.setBorder(null);
        txtNumberOfTicktsNormal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumberOfTicktsNormalFocusGained(evt);
            }
        });
        jPanel6.add(txtNumberOfTicktsNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, 30));

        jLabel31.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 102, 0));
        jLabel31.setText("NumberOfTickts");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 20));

        txtNormalId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtNormalId.setBorder(null);
        txtNormalId.setEnabled(false);
        txtNormalId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNormalIdFocusGained(evt);
            }
        });
        jPanel6.add(txtNormalId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 120, 30));

        k1.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        k1.setForeground(new java.awt.Color(255, 102, 0));
        k1.setText("Id");
        jPanel6.add(k1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 20));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 270, 180));

        jLabel17.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("Team One");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 76, -1));

        txtHomeTeamId.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtHomeTeamId.setBorder(null);
        txtHomeTeamId.setEnabled(false);
        txtHomeTeamId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHomeTeamIdFocusGained(evt);
            }
        });
        getContentPane().add(txtHomeTeamId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 45, 35));

        jLabel18.setFont(new java.awt.Font("Lemonada SemiBold", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 102, 0));
        jLabel18.setText("Team Name");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 82, 35));

        txtHomeTeamName.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txtHomeTeamName.setBorder(null);
        txtHomeTeamName.setEnabled(false);
        txtHomeTeamName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHomeTeamNameFocusGained(evt);
            }
        });
        txtHomeTeamName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHomeTeamNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtHomeTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 251, 35));

        btChooseHomeTeam.setFont(new java.awt.Font("Lemonada SemiBold", 1, 14)); // NOI18N
        btChooseHomeTeam.setForeground(new java.awt.Color(255, 102, 0));
        btChooseHomeTeam.setText("Choose");
        btChooseHomeTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChooseHomeTeamActionPerformed(evt);
            }
        });
        getContentPane().add(btChooseHomeTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 111, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:

        this.dispose();
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

    private void txtHomeTeamIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHomeTeamIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHomeTeamIdFocusGained

    private void txtHomeTeamNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHomeTeamNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHomeTeamNameFocusGained

    private void btChooseHomeTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooseHomeTeamActionPerformed

        TeamChose chose = new TeamChose(1);
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }//GEN-LAST:event_btChooseHomeTeamActionPerformed

    private void txtStadiumIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStadiumIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStadiumIdFocusGained

    private void txtStadiumNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStadiumNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStadiumNameFocusGained

    private void btStaduimChosseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStaduimChosseActionPerformed
        StadiumChose chose = new StadiumChose();
        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btStaduimChosseActionPerformed

    private void txtAwayTeamIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAwayTeamIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAwayTeamIdFocusGained

    private void txtPriceVipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceVipFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceVipFocusGained

    private void btChooesAwayTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooesAwayTeamActionPerformed
        TeamChose chose = new TeamChose(2);
//        chose.pack();
        chose.setVisible(true);
        chose.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    }//GEN-LAST:event_btChooesAwayTeamActionPerformed

    private void txtTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeFocusGained

    private void txtCityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCityFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityFocusGained

    private void txtHomeTeamNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHomeTeamNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHomeTeamNameActionPerformed

    private void txtNumberSeatesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumberSeatesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberSeatesFocusGained

    private void btSave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSave3ActionPerformed

        timePicker1.showPopup(this, 100, 100);


    }//GEN-LAST:event_btSave3ActionPerformed

    private void btSave4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSave4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSave4ActionPerformed

    private void txtNumberParksFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumberParksFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberParksFocusGained

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed

        if (op == 1) {
            try {
                addMachFootball();
            } catch (ParseException ex) {
                Logger.getLogger(FootballMatchNew.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
            new FootballView().setVisible(true);

        } else if (op == 2) {
            try {
                updateData();
            } catch (ParseException ex) {
                Logger.getLogger(FootballMatchNew.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
            new FootballView().setVisible(true);

        }


    }//GEN-LAST:event_btSaveActionPerformed

    private void rbVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVipActionPerformed

        typeVip = "Vip";  // if choose gender this method call
    }//GEN-LAST:event_rbVipActionPerformed

    private void rbNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNormalActionPerformed
        typeNormal = "Normal";
    }//GEN-LAST:event_rbNormalActionPerformed

    private void txtAwayTeamName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAwayTeamName1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAwayTeamName1FocusGained

    private void txtPriceNormalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceNormalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceNormalFocusGained

    private void txtNumberOfTicktsNormalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumberOfTicktsNormalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfTicktsNormalFocusGained

    private void txtNumberOfTicktsVipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumberOfTicktsVipFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfTicktsVipFocusGained

    private void txtVipIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVipIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVipIdFocusGained

    private void txtNormalIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNormalIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNormalIdFocusGained

    private void MatchNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MatchNumberFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_MatchNumberFocusGained

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
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
                    new FootballMatchNew().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FootballMatchNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField MatchNumber;
    private javax.swing.JButton btChooesAwayTeam;
    private javax.swing.JButton btChooseHomeTeam;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSave3;
    private javax.swing.JButton btSave4;
    private javax.swing.JButton btStaduimChosse;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel k;
    private javax.swing.JLabel k1;
    private javax.swing.JRadioButton rbNormal;
    private javax.swing.JRadioButton rbVip;
    private com.raven.swing.TimePicker timePicker1;
    public static javax.swing.JTextField txtAwayTeamId;
    public static javax.swing.JTextField txtAwayTeamName1;
    public static javax.swing.JTextField txtCity;
    private com.toedter.calendar.JDateChooser txtDateTime;
    public static javax.swing.JTextField txtHomeTeamId;
    public static javax.swing.JTextField txtHomeTeamName;
    public static javax.swing.JTextField txtNormalId;
    public static javax.swing.JTextField txtNumberOfTicktsNormal;
    public static javax.swing.JTextField txtNumberOfTicktsVip;
    public static javax.swing.JTextField txtNumberParks;
    public static javax.swing.JTextField txtNumberSeates;
    public static javax.swing.JTextField txtPriceNormal;
    public static javax.swing.JTextField txtPriceVip;
    public static javax.swing.JTextField txtStadiumId;
    public static javax.swing.JTextField txtStadiumName;
    private javax.swing.JTextField txtTeanId5;
    public static javax.swing.JTextField txtTime;
    public static javax.swing.JTextField txtVipId;
    // End of variables declaration//GEN-END:variables
}
