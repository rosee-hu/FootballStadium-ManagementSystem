/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem;

import AdminOP.FootballMatchNew;
import static com.mycompany.footballstadiumticketsystem.DBconnect.DBPwd;
import static com.mycompany.footballstadiumticketsystem.DBconnect.DBURL;
import static com.mycompany.footballstadiumticketsystem.DBconnect.DBUser;
import com.mycompany.footballstadiumticketsystem.model.Admin;
import com.mycompany.footballstadiumticketsystem.model.Categories;
import com.mycompany.footballstadiumticketsystem.model.Customer;
import com.mycompany.footballstadiumticketsystem.model.Invoice;
import com.mycompany.footballstadiumticketsystem.model.MatchFootball;
import com.mycompany.footballstadiumticketsystem.model.Matchticket;
import com.mycompany.footballstadiumticketsystem.model.Payment;
import com.mycompany.footballstadiumticketsystem.model.PaymentCach;
import com.mycompany.footballstadiumticketsystem.model.PaymentCard;
import com.mycompany.footballstadiumticketsystem.model.Preson;
import com.mycompany.footballstadiumticketsystem.model.Services;
import com.mycompany.footballstadiumticketsystem.model.Stadiums;
import com.mycompany.footballstadiumticketsystem.model.Teams;
import com.mycompany.footballstadiumticketsystem.model.Ticket;
import com.mycompany.footballstadiumticketsystem.model.TotelPayment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DataService {

    Connection con = DBconnect.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;

    public int GetNextValue(String table, String feild) throws SQLException {
        int result = 1;

        Statement st;
        ResultSet rs;

        st = con.createStatement();
        rs = st.executeQuery("SELECT MAX(" + feild + ") FROM " + table + " ");
        while (rs.next()) {
            result = rs.getInt(1);
        }

        return (result + 1);

    }

    //Stadiums Sql
    public int InsertStadiums(Stadiums stadiums) throws SQLException {
        int result = 0;
        int id = GetNextValue("Stadiums", "StadiumId");

        PreparedStatement newStock;

        String query = "INSERT INTO Stadiums (StadiumId,StadiumName,City,NumberSteas,NumberOfParks) VALUES (?,?,?,?,?)";

        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setString(2, stadiums.getStadiumName());
        newStock.setString(3, stadiums.getCity());
        newStock.setInt(4, stadiums.getNumberOfSeates());
        newStock.setInt(5, stadiums.getNumberOfParks());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectStadiums() {
        ArrayList<Stadiums> stadiumses = new ArrayList();
        try {

            String sql = "SELECT * FROM Stadiums";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                stadiumses.add(new Stadiums(rs.getInt("StadiumID"),
                        rs.getString("StadiumName"), rs.getString("City"),
                        rs.getInt("NumberSteas"), rs.getInt("NumberOfParks")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stadiumses;
    }

    public void updateStadiums(int id, Stadiums stadiums) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE Stadiums set StadiumName  = ?, City = ? ,NumberSteas=?, NumberOfParks=?"
                    + " WHERE StadiumID = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, stadiums.getStadiumName());
            newStock.setString(2, stadiums.getCity());
            newStock.setInt(3, stadiums.getNumberOfSeates());
            newStock.setInt(4, stadiums.getNumberOfParks());

            newStock.setInt(5, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteStadiums(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM Stadiums WHERE StadiumID = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    //Teams Sql
    public int InsertTeams(Teams teams) throws SQLException {
        int result = 0;
        int id = GetNextValue("Teams", "TeamId");
        PreparedStatement newStock;

        String query = "INSERT INTO Teams (TeamId,TeamName,DateOfEstablishment,Loaction) VALUES (?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setString(2, teams.getTeamName());
        newStock.setDate(3, teams.getDateOfEstablishment());
        newStock.setString(4, teams.getLoaction());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectTeams() {
        ArrayList<Teams> teamses = new ArrayList();
        try {

            String sql = "SELECT TeamID, TeamName,DateOfEstablishment,Loaction FROM Teams";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                teamses.add(new Teams(rs.getInt("TeamID"), rs.getString("TeamName"),
                        rs.getDate("DateOfEstablishment"),
                        rs.getString("Loaction")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teamses;
    }

    public void updateTeams(int id, Teams teams) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE Teams set TeamName  = ?,DateOfEstablishment= ?,Loaction= ?"
                    + " WHERE TeamID = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, teams.getTeamName());
            newStock.setDate(2, teams.getDateOfEstablishment());
            newStock.setString(3, teams.getLoaction());

            newStock.setInt(4, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteTeams(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM Teams WHERE TeamID = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    //MachFootball Sql
    public int InsertMachFootball(MatchFootball football) throws SQLException {
        int result = 0;
        int id = GetNextValue("footballmatch", "MatchNumber");

        PreparedStatement newStock;

        String query = "INSERT INTO footballmatch ( MatchNumber,Home_Team, Away_Team, DateMatch, "
                + "TimeMatch, Status, StadiumID) VALUES (?,?,?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setInt(2, football.getHome_Team().getTeamID());
        newStock.setInt(3, football.getAway_Team().getTeamID());
        newStock.setDate(4, football.getDateMatch());
        newStock.setTime(5, football.getTimeMatch());
        newStock.setInt(6, football.getStatus());
        newStock.setInt(7, football.getStadiumID().getStadiumID());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectMachFootball() {

        ArrayList<MatchFootball> teamses = new ArrayList();
        try {

            String sql = " SELECT MatchNumber,s.StadiumID,\n"
                    + "StadiumName, \n"
                    + "t.TeamID as Home_TeamId ,"
                    + " t.TeamName as Home_TeamName,a.TeamID as Away_TeamId ,"
                    + " a.TeamName as Away_TeamName,DateMatch, TimeMatch , City, NumberSteas, NumberOfParks \n"
                    + "\n"
                    + "FROM footballmatch f ,teams t,teams a,stadiums s where f.StadiumID=s.StadiumID\n"
                    + "and f.Home_Team=t.TeamID\n"
                    + "and f.Away_Team=a.TeamID";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Teams hometeam = new Teams(rs.getInt("Home_TeamId"), rs.getString("Home_TeamName"));
                Teams awayTeam = new Teams(rs.getInt("Away_TeamId"), rs.getString("Away_TeamName"));
                Stadiums stadiums = new Stadiums(rs.getInt("StadiumID"),
                        rs.getString("StadiumName"), rs.getString("City"),
                        rs.getInt("NumberSteas"), rs.getInt("NumberOfParks"));
                teamses.add(new MatchFootball(rs.getInt("MatchNumber"), hometeam, awayTeam,
                        rs.getDate("DateMatch"), rs.getTime("TimeMatch"), 1, stadiums));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teamses;
    }

    public void updateMachFootball(int id, MatchFootball football) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE footballmatch set Home_Team =?, Away_Team=?, DateMatch=?, "
                    + "TimeMatch=?, StadiumID  = ?"
                    + " WHERE MatchNumber = ?";

            newStock = con.prepareStatement(sql);
            newStock.setInt(1, football.getHome_Team().getTeamID());
            newStock.setInt(2, football.getAway_Team().getTeamID());
            newStock.setDate(3, football.getDateMatch());
            newStock.setTime(4, football.getTimeMatch());
            newStock.setInt(5, football.getStadiumID().getStadiumID());

            newStock.setInt(6, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteMachFootball(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM footballmatch WHERE MatchNumber = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }

    }

    //Ticket Sql
    public int InsertTicket(Ticket ticket) throws SQLException {
        int result = 0;
        int idd = GetNextValue("tickets", "TicketId");

        PreparedStatement newStock;

        int id = geteMachFootballId();
        String query = "INSERT INTO tickets (TicketId,Type, NumberOfTickts, MatchNumber, Price) VALUES (?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, idd);

        newStock.setString(2, ticket.getType());
        newStock.setInt(3, ticket.getNumberOfTickts());
        newStock.setInt(4, id);
        newStock.setDouble(5, ticket.getPrice());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectTicket() {

        ArrayList<MatchFootball> teamses = new ArrayList();
        ArrayList<Ticket> tickets = new ArrayList();

        try {

            String sql = " SELECT TicketId, Type, NumberOfTickts, Price, f.MatchNumber,s.StadiumID, StadiumName, t.TeamID as Home_TeamId ,"
                    + " t.TeamName as Home_TeamName,a.TeamID as Away_TeamId , a.TeamName as Away_TeamName,DateMatch, TimeMatch ,"
                    + " City, NumberSteas, NumberOfParks FROM footballmatch f ,teams t,teams a,stadiums s,tickets ti "
                    + "where f.StadiumID=s.StadiumID and f.Home_Team=t.TeamID and f.Away_Team=a.TeamID AND f.MatchNumber=ti.MatchNumber";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Teams hometeam = new Teams(rs.getInt("Home_TeamId"), rs.getString("Home_TeamName"));
                Teams awayTeam = new Teams(rs.getInt("Away_TeamId"), rs.getString("Away_TeamName"));
                Stadiums stadiums = new Stadiums(rs.getInt("StadiumID"),
                        rs.getString("StadiumName"), rs.getString("City"),
                        rs.getInt("NumberSteas"), rs.getInt("NumberOfParks"));
                MatchFootball football = new MatchFootball(rs.getInt("MatchNumber"), hometeam, awayTeam,
                        rs.getDate("DateMatch"), rs.getTime("TimeMatch"), 1, stadiums);
                tickets.add(new Ticket(rs.getInt("TicketId"), rs.getString("Type"),
                        rs.getDouble("Price"), football));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public ArrayList SelectTicket(int fooyballId) {

        ArrayList<Ticket> tickets = new ArrayList();

        try {

            String sql = " SELECT TicketId, Type, NumberOfTickts, Price FROM footballmatch f ,tickets ti "
                    + "where  f.MatchNumber=ti.MatchNumber and f.MatchNumber=? ";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, fooyballId);
            rs = this.pst.executeQuery();
            while (rs.next()) {

                MatchFootball football = new MatchFootball();
                tickets.add(new Ticket(rs.getInt("TicketId"), rs.getString("Type"),
                        rs.getDouble("Price"), rs.getInt("NumberOfTickts"), football));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public void updateTicket(int id, Ticket ticket) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE tickets set Type=?, NumberOfTickts=?, Price  = ?"
                    + " WHERE TicketId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, ticket.getType());
            newStock.setInt(2, ticket.getNumberOfTickts());
            newStock.setDouble(3, ticket.getPrice());
            newStock.setInt(4, id);

            newStock.execute();
            // JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteTicket(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM tickets WHERE TicketId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    //Matchticket Sql

    public int InsertMatchticket(Matchticket matchticket) throws SQLException {
        int result = 0;
        int id = GetNextValue("matchticket", "MatchTicketId");

        PreparedStatement newStock;

        String query = "Insert Into matchticket(MatchTicketId,TicketId, CustomerId, SeatesId, ParksId) VALUES (?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setInt(2, matchticket.getTicket().getTicketId());
        newStock.setInt(3, matchticket.getPreson().getId());
        newStock.setInt(4, matchticket.getParksId());
        newStock.setInt(5, matchticket.getSeatesId());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectTicketUser() {

        ArrayList<Matchticket> matchtickets = new ArrayList();

        try {

            String sql = " SELECT vip.TicketId , vip.Type, vip.NumberOfTickts, vip.Price,"
                    + " nor.TicketId as NorTicketId, nor.Type as NorType, nor.NumberOfTickts as NorNumberOfTickts, nor.Price as NorPrice, "
                    + "f.MatchNumber,s.StadiumID, StadiumName, t.TeamID as Home_TeamId , t.TeamName as Home_TeamName,a.TeamID as Away_TeamId ,"
                    + " a.TeamName as Away_TeamName,DateMatch, TimeMatch , City, NumberSteas, NumberOfParks "
                    + "FROM footballmatch f ,teams t,teams a,stadiums s,tickets vip ,tickets nor"
                    + " where f.StadiumID=s.StadiumID and f.Home_Team=t.TeamID and "
                    + "f.Away_Team=a.TeamID AND f.MatchNumber=vip.MatchNumber and"
                    + " f.MatchNumber=nor.MatchNumber and vip.Type='vip' and nor.Type='normal'";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Teams hometeam = new Teams(rs.getInt("Home_TeamId"), rs.getString("Home_TeamName"));
                Teams awayTeam = new Teams(rs.getInt("Away_TeamId"), rs.getString("Away_TeamName"));
                Stadiums stadiums = new Stadiums(rs.getInt("StadiumID"),
                        rs.getString("StadiumName"), rs.getString("City"),
                        rs.getInt("NumberSteas"), rs.getInt("NumberOfParks"));
                MatchFootball football = new MatchFootball(rs.getInt("MatchNumber"), hometeam, awayTeam,
                        rs.getDate("DateMatch"), rs.getTime("TimeMatch"), 1, stadiums);
                Ticket vip = new Ticket(rs.getInt("TicketId"), rs.getString("Type"),
                        rs.getDouble("Price"), football);
                Ticket normal = new Ticket(rs.getInt("NorTicketId"), rs.getString("NorType"),
                        rs.getDouble("NorPrice"), football);
                Customer c = new Customer();

                matchtickets.add(new Matchticket(1, vip, c, 1, 1, normal));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matchtickets;
    }

    public ArrayList SelectMatchticket(int id) {

        ArrayList<Matchticket> matchtickets = new ArrayList();

        try {

            String sql = " SELECT m.*, ti.*, f.MatchNumber,s.StadiumID, StadiumName, t.TeamID as Home_TeamId ,\n"
                    + "            t.TeamName as Home_TeamName,t.DateOfEstablishment as HDateOfEstablishment,t.Loaction as HLoaction,"
                    + "a.TeamID as Away_TeamId , a.TeamName as Away_TeamName,a.DateOfEstablishment as ADateOfEstablishment,A.Loaction as ALoaction"
                    + ",DateMatch, TimeMatch ,\n"
                    + "                                     City, NumberSteas, NumberOfParks,\n"
                    + "                                     (SELECT Sum(s.Price*i.Count) FROM services s , invoice i where s.ServiceId=i.ServiceId and i.MatchITicketId=m.MatchTicketId) as PriceService\n"
                    + "                                     FROM footballmatch f ,teams t,teams a,stadiums s,tickets ti ,matchticket m\n"
                    + "                                       where f.StadiumID=s.StadiumID and f.Home_Team=t.TeamID and f.Away_Team=a.TeamID \n"
                    + "                                      AND f.MatchNumber=ti.MatchNumber and ti.TicketId=m.TicketId and m.CustomerId=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Teams hometeam = new Teams(rs.getInt("Home_TeamId"), rs.getString("Home_TeamName"),
                        rs.getDate("HDateOfEstablishment"), rs.getString("HLoaction"));
                Teams awayTeam = new Teams(rs.getInt("Away_TeamId"), rs.getString("Away_TeamName"),
                        rs.getDate("ADateOfEstablishment"), rs.getString("ALoaction"));
                Stadiums stadiums = new Stadiums(rs.getInt("StadiumID"),
                        rs.getString("StadiumName"), rs.getString("City"),
                        rs.getInt("NumberSteas"), rs.getInt("NumberOfParks"));
                MatchFootball football = new MatchFootball(rs.getInt("MatchNumber"), hometeam, awayTeam,
                        rs.getDate("DateMatch"), rs.getTime("TimeMatch"), 1, stadiums);
                Ticket ticket = new Ticket(rs.getInt("TicketId"), rs.getString("Type"),
                        rs.getDouble("Price"), football);
                Customer c = new Customer();
                matchtickets.add(new Matchticket(rs.getInt("MatchTicketId"), ticket, c, rs.getInt("SeatesId"), rs.getInt("ParksId"), rs.getDouble("PriceService")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(matchtickets.size());

        return matchtickets;
    }

    public void updateMatchticketl(int id, Teams stadiums) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE matchticket set SeatesId=?, ParksId  = ?"
                    + " WHERE TicketId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, stadiums.getTeamName());

            newStock.setInt(2, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteMatchticket(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM matchticket WHERE MatchTicketId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

    }

    //Invoice Sql
    public int InsertInvoice(Invoice invoice) throws SQLException {
        int result = 0;
        int id = GetNextValue("invoice", "InvoiceId");

        PreparedStatement newStock;

        String query = "Insert Into invoice(InvoiceId, MatchITicketId, Count,ServiceId) VALUES (?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setInt(2, invoice.getMatchticket().getMatchTicketId());
        newStock.setInt(3, invoice.getCount());
        newStock.setInt(4, invoice.getServices().getServiceId());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectInvoice(int mticket) {

        ArrayList<Invoice> invoices = new ArrayList();

        try {

            String sql = " SELECT InvoiceId, s.ServiceId ,ServiceName,ServiceType,Price,Count,s.CategorieId,c.CategorieName FROM services s , invoice i,categories c\n"
                    + "where s.ServiceId=i.ServiceId and  c.CategorieId=s.CategorieId\n"
                    + "and i.MatchITicketId= ?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, mticket);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setCategorieId(rs.getInt("CategorieId"));
                c.setCategorieName(rs.getString("CategorieName"));
                Services services = new Services(rs.getInt("ServiceId"),
                        rs.getString("ServiceName"), rs.getString("ServiceType"),
                        rs.getDouble("Price"), c
                );

                invoices.add(new Invoice(rs.getInt("InvoiceId"), services, rs.getInt("Count")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return invoices;
    }

    public void updateInvoice(int id, Invoice invoice) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE invoice set  Count=?,ServiceId  = ?"
                    + " WHERE InvoiceId = ?";

            newStock = con.prepareStatement(sql);
           // newStock.setInt(1, invoice.getMatchticket().getMatchTicketId());
            newStock.setInt(1, invoice.getCount());
            newStock.setInt(2, invoice.getServices().getServiceId());

            newStock.setInt(3, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteInvoice(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM invoice WHERE invoiceId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public TotelPayment SelectTotelPayment(int custId) {

        TotelPayment payment = new TotelPayment();
        try {

            String sql = "SELECT sum((SELECT (pc.Amount) from paymentcach pc where p.PaymentId=pc.PaymentId )) as PayCach "
                    + ",sum((SELECT (pca.Amount) from paymentcard pca where p.PaymentId=pca.PaymentId )) as PayCard FROM payment p WHERE p.MatchTicketId in ( SELECT matchticket.MatchTicketId    FROM matchticket \n"
                    + "                                       where  CustomerId=?) ";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, custId);

            rs = this.pst.executeQuery();
            if (rs.next()) {

                payment.setPayCach(rs.getInt("PayCach"));

                payment.setPayCard(rs.getInt("PayCard"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return payment;
    }

    //PaymentCach Sql
    public int InsertPaymentcach(PaymentCach cach) throws SQLException {
        int result = 0;
        int id = GetNextValue("payment", "PaymentId");

        PreparedStatement newStock;

        String query = "INSERT INTO payment(PaymentId, MatchTicketId, Date) VALUES (?,?,?)";
        newStock = con.prepareStatement(query);
                newStock.setInt(1, id);

        newStock.setInt(2, cach.getMatchticket().getMatchTicketId());
        newStock.setDate(3, cach.getDatePay());

        result = newStock.executeUpdate();

        int paymentId = getePayment();
        query = "INSERT INTO paymentcach( PaymentId, Amount) VALUES (?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, paymentId);
        newStock.setDouble(2, cach.getAmount());

        result = newStock.executeUpdate();
        return result;

    }

    public ArrayList SelectPaymentcach(int mticket) {

        ArrayList<PaymentCach> paymentCachs = new ArrayList();

        try {

            String sql = "SELECT p.PaymentId, p.MatchTicketId, Date,Amount\n"
                    + "FROM payment p ,paymentcach pc,matchticket m \n"
                    + "WHERE p.PaymentId=pc.PaymentId\n"
                    + "and m.MatchTicketId=p.MatchTicketId and "
                    + "p.MatchTicketId = ?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, mticket);

            rs = this.pst.executeQuery();
            while (rs.next()) {

                Matchticket matchticket = new Matchticket();
                matchticket.setMatchTicketId(rs.getInt("MatchTicketId"));

                paymentCachs.add(new PaymentCach(rs.getDouble("Amount"), rs.getInt("PaymentId"),
                        matchticket, rs.getDate("Date")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paymentCachs;
    }

    public void updatePaymentCach(int id, PaymentCach cach) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE payment set Date  = ?"
                    + " WHERE PaymentId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setDate(1, cach.getDatePay());
            newStock.setInt(2, id);

            newStock.execute();
            sql = "UPDATE paymentcach set Amount  = ?"
                    + " WHERE PaymentId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setDouble(1, cach.getAmount());
            newStock.setInt(2, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deletePaymentCach(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM payment WHERE PaymentId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            sql = "DELETE FROM paymentcach WHERE PaymentId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    //PaymentCard Sql

    public int InsertPaymentCard(PaymentCard card) throws SQLException {
        int result = 0;
        int id = GetNextValue("payment", "PaymentId");

        PreparedStatement newStock;

        String query = "INSERT INTO payment(PaymentId, MatchTicketId, Date) VALUES (?,?,?)";
        newStock = con.prepareStatement(query);
                        newStock.setInt(1, id);

        newStock.setInt(2, card.getMatchticket().getMatchTicketId());
        newStock.setDate(3, card.getDatePay());

        result = newStock.executeUpdate();

        int paymentId = getePayment();
        query = "INSERT INTO paymentcard(PaymentId, cardNumber, CardName, Amount) VALUES (?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, paymentId);
        newStock.setInt(2, card.getCardNumber());
        newStock.setString(3, card.getCardName());

        newStock.setDouble(4, card.getAmount());

        result = newStock.executeUpdate();
        return result;

    }

    public ArrayList SelectPaymentCard(int mticket) {

        ArrayList<PaymentCard> paymentCard = new ArrayList();

        try {

            String sql = "SELECT p.PaymentId, p.MatchTicketId, Date,pc.*\n"
                    + "FROM payment p ,paymentcard pc,matchticket m \n"
                    + "WHERE p.PaymentId=pc.PaymentId\n"
                    + "and m.MatchTicketId=p.MatchTicketId and "
                    + "p.MatchTicketId = ?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, mticket);

            rs = this.pst.executeQuery();
            while (rs.next()) {

                Matchticket matchticket = new Matchticket();
                matchticket.setMatchTicketId(rs.getInt("MatchTicketId"));
                paymentCard.add(new PaymentCard(rs.getInt("CardNumber"), rs.getString("CardName"),
                        rs.getDouble("Amount"), rs.getInt("PaymentId"),
                        matchticket, rs.getDate("Date")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paymentCard;
    }

    public void updatePaymentCard(int id, PaymentCard card) {
        try {
            PreparedStatement newStock;
            String sql = "UPDATE payment set Date  = ?"
                    + " WHERE PaymentId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setDate(1, card.getDatePay());

            newStock.setInt(2, id);

            newStock.execute();
            // Connection c = con();PaymentId, cardNumber, CardName, Amount
            sql = "UPDATE paymentcard set cardNumber  = ?,CardName=?,Amount=?"
                    + " WHERE PaymentId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setInt(1, card.getCardNumber());
            newStock.setString(2, card.getCardName());

            newStock.setDouble(3, card.getAmount());
            newStock.setInt(4, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deletePaymentCard(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM paymentcard WHERE PaymentId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            sql = "DELETE FROM payment WHERE PaymentId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public int getePayment() {
        int data = 0;

        try {

            String sql = "SELECT max(PaymentId) as Id From payment";

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            if (rs.next()) {

                data = rs.getInt("Id");

                return data;

            } else {

            }

        } catch (Exception e) {

        }
        return data;
    }

    // op User
    public int getId() {
        int data = 0;

        try {

            String sql = "SELECT max(Id) as Id From preson";

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            if (rs.next()) {

                data = rs.getInt("Id");

                return data;

            } else {

            }

        } catch (Exception e) {

        }
        return data;
    }

    public int geteMachFootballId() {
        int data = 0;

        try {

            String sql = "SELECT max(MatchNumber) as Id From footballmatch";

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            if (rs.next()) {

                data = rs.getInt("Id");

                return data;

            } else {

            }

        } catch (Exception e) {

        }
        return data;
    }

    public Customer getUser(Customer customer) {

        String email = customer.getUserName();
        String password = customer.getPassword();

        try {

            String sql = "SELECT p.*,c.* From preson p,customer c WHERE UserName=? and Password=? and p.Id=c.Id";

            this.pst = con.prepareStatement(sql);
           this. pst.setString(1, email);
            this.pst.setString(2, password);

            rs = this.pst.executeQuery();

            if (rs.next()) {

//                JOptionPane.showMessageDialog(null, "Login Successfully" + "  " + preson.getUserName());
                customer.setId(rs.getInt("Id"));

                customer.setUserName(rs.getString("UserName"));
                customer.setFname(rs.getString("Fname"));
                customer.setLname(rs.getString("Lname"));
                customer.setPhone(rs.getString("Phone"));
                customer.setGender(rs.getString("Genader"));
                customer.setAddress(rs.getString("Address"));
                customer.setAge(rs.getInt("Age"));

                return customer;

            } else {
                JOptionPane.showMessageDialog(null, "Login  not Successfully");
                /*if(Integer.valueOf(username.getText()) == 774145082 && Integer.valueOf(password.getText()) == 4321 )
          {
              new create_account_users().setVisible(true);
              this.dispose();
          }*/
            }

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login   "+e.getMessage());

        }
        return customer;
    }

    public Admin getAdmin(Admin admin) {

        String email = admin.getUserName();
        String password =admin.getPassword();

        try {

            String sql = "SELECT p.*,a.* From preson p,admin a WHERE UserName=? and Password=? and p.Id=a.Id";

        this.pst = con.prepareStatement(sql);
           this. pst.setString(1, email);
            this.pst.setString(2, password);

        rs = this.pst.executeQuery();

            if (rs.next()) {

//                JOptionPane.showMessageDialog(null, "Login Successfully" + "  " + preson.getUserName());
                admin.setId(rs.getInt("Id"));

                admin.setUserName(rs.getString("UserName"));
                admin.setFname(rs.getString("Fname"));
                admin.setLname(rs.getString("Lname"));
                admin.setGender(rs.getString("Genader"));
                admin.setJop(rs.getString("Jop"));
                JOptionPane.showMessageDialog(null, "Login "+admin.getLname());

                return admin;

            } else {
                JOptionPane.showMessageDialog(null, "Login  not Successfully");
                /*if(Integer.valueOf(username.getText()) == 774145082 && Integer.valueOf(password.getText()) == 4321 )
          {
              new create_account_users().setVisible(true);
              this.dispose();
          }*/
            }

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login  not Successfully"+e.getMessage());

        }
        return admin;
    }

    public int InsertCustomer(Customer Customer) throws SQLException {
        int result = 0;

        PreparedStatement newStock;

        int id = GetNextValue("preson", "Id");
        String query = " INSERT INTO preson( Id,Fname, Lname, Genader, Type, UserName, Password) VALUES (?,?,?,?,?,?,?)";
        newStock = con.prepareStatement(query);
                newStock.setInt(1, id);

        newStock.setString(2, Customer.getFname());
        newStock.setString(3, Customer.getLname());
        newStock.setString(4, Customer.getGender());
        newStock.setString(5, Customer.getType());
        newStock.setString(6, Customer.getUserName());
        newStock.setString(7, Customer.getPassword());

        result = newStock.executeUpdate();

        query = "INSERT INTO customer(Id, Phone, Address, Age) VALUES (?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);
        newStock.setString(2, Customer.getPhone());
        newStock.setString(3, Customer.getAddress());
        newStock.setInt(4, Customer.getAge());

        result = newStock.executeUpdate();

        return result;

    }
     public void deleteCustomer(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM preson WHERE Id = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
              sql = "DELETE FROM customer WHERE Id = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public ArrayList getUserAll() throws SQLException {
        Customer customer;
        ArrayList<Customer> customers = new ArrayList();

        String sql = "SELECT p.*,c.* From preson p,customer c where  p.Id=c.Id";

        this.pst = con.prepareStatement(sql);
        rs = this.pst.executeQuery();
        while (rs.next()) {

            customer = new Customer();
            customer.setId(rs.getInt("Id"));

            customer.setUserName(rs.getString("UserName"));
            customer.setFname(rs.getString("Fname"));
            customer.setLname(rs.getString("Lname"));
            customer.setPhone(rs.getString("Phone"));
            customer.setGender(rs.getString("Genader"));
            customer.setAddress(rs.getString("Address"));
            customer.setAge(rs.getInt("Age"));
            customers.add(customer);
        }

        return customers;
    }

//Categories Sql `(``, `
    public int InsertCategories(Categories categories) throws SQLException {
        int result = 0;
        int id = GetNextValue("categories", "CategorieId");

        PreparedStatement newStock;

        String query = "INSERT INTO categories (CategorieId,CategorieName) VALUES (?,?)";
        newStock = con.prepareStatement(query);
                newStock.setInt(1, id);

        newStock.setString(2, categories.getCategorieName());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectCate() {
        ArrayList<Categ> categorieses = new ArrayList();
        try {

            String sql = "SELECT * FROM categories";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                categorieses.add(new Categ(rs.getInt("CategorieId"),
                        rs.getString("CategorieName")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categorieses;
    }

    public ArrayList SelectCategories() {
        ArrayList<Categories> categorieses = new ArrayList();
        try {

            String sql = "SELECT * FROM categories";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                categorieses.add(new Categories(rs.getInt("CategorieId"),
                        rs.getString("CategorieName")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categorieses;
    }

    public void updateCategories(int id, Categories categories) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE categories set CategorieName  =?"
                    + " WHERE CategorieId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, categories.getCategorieName());

            newStock.setInt(2, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteCategories(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM categories WHERE CategorieId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    //Categories Sql services`(`ServiceId`, ``, ``, ``, `` `
    public int InsertServices(Services services) throws SQLException {
        int result = 0;
        int id = GetNextValue("services", "ServiceId");

        PreparedStatement newStock;

        String query = "INSERT INTO services (ServiceId,ServiceName,ServiceType,CategorieId,Price) VALUES (?,?,?,?,?)";
        newStock = con.prepareStatement(query);
                    newStock.setInt(1, id);

        newStock.setString(2, services.getServiceName());
        newStock.setString(3, services.getServiceType());
        newStock.setInt(4, services.getCategories().getCategorieId());
        newStock.setDouble(5, services.getPrice());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectServices() {
        ArrayList<Services> serviceses = new ArrayList();
        try {

            String sql = "SELECT ServiceId,ServiceName, ServiceType, Price,s.CategorieId,c.CategorieName FROM services s"
                    + " , categories c where c.CategorieId=s.CategorieId";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setCategorieId(rs.getInt("CategorieId"));
                c.setCategorieName(rs.getString("CategorieName"));

                serviceses.add(new Services(rs.getInt("ServiceId"),
                        rs.getString("ServiceName"), rs.getString("ServiceType"),
                        rs.getDouble("Price"), c
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return serviceses;
    }

    public ArrayList SelectServicesByCategorieId(int catId) {
        ArrayList<Services> serviceses = new ArrayList();
        try {

            String sql = "SELECT ServiceId,ServiceName, ServiceType, Price FROM services s"
                    + " , categories c where c.CategorieId=s.CategorieId  and c.CategorieId=? ";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, catId);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();

                serviceses.add(new Services(rs.getInt("ServiceId"),
                        rs.getString("ServiceName"), rs.getString("ServiceType"),
                        rs.getDouble("Price"), c
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return serviceses;
    }

    public void updateServices(int id, Services services) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE services set ServiceName =?,"
                    + "ServiceType =?,CategorieId =?,Price =?"
                    + " WHERE ServiceId = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, services.getServiceName());
            newStock.setString(2, services.getServiceType());
            newStock.setInt(3, services.getCategories().getCategorieId());
            newStock.setDouble(4, services.getPrice());

            newStock.setInt(5, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteServices(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM services WHERE ServiceId = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

}
