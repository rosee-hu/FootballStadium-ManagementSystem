/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

/**
 *
 * @author ASUS
 */
public class Matchticket {
   
    private int MatchTicketId;
    private  Ticket ticket;
    private Customer preson;
    private  int SeatesId;
    private  int ParksId;
        private  Ticket normal;
        
        private double PriceServise;

    public double getPriceServise() {
        return PriceServise;
    }

    public void setPriceServise(double PriceServise) {
        this.PriceServise = PriceServise;
    }

    public Matchticket(int MatchTicketId, Ticket ticket, Customer preson, int SeatesId, 
            int ParksId, double PriceServise) {
        this.MatchTicketId = MatchTicketId;
        this.ticket = ticket;
        this.preson = preson;
        this.SeatesId = SeatesId;
        this.ParksId = ParksId;
        this.PriceServise = PriceServise;
    }

    public Matchticket(int MatchTicketId, Ticket ticket, Customer preson, int SeatesId, int ParksId, Ticket normal) {
        this.MatchTicketId = MatchTicketId;
        this.ticket = ticket;
        this.preson = preson;
        this.SeatesId = SeatesId;
        this.ParksId = ParksId;
        this.normal = normal;
    }

    public Ticket getNormal() {
        return normal;
    }

    public void setNormal(Ticket normal) {
        this.normal = normal;
    }


    public Matchticket() {
    }

    public Matchticket(int MatchTicketId, Ticket ticket, Customer preson, int SeatesId, int ParksId) {
        this.MatchTicketId = MatchTicketId;
        this.ticket = ticket;
        this.preson = preson;
        this.SeatesId = SeatesId;
        this.ParksId = ParksId;
    }

   

    public int getMatchTicketId() {
        return MatchTicketId;
    }

    public void setMatchTicketId(int MatchTicketId) {
        this.MatchTicketId = MatchTicketId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Customer getPreson() {
        return preson;
    }

    public void setPreson(Customer preson) {
        this.preson = preson;
    }

    public int getSeatesId() {
        return SeatesId;
    }

    public void setSeatesId(int SeatesId) {
        this.SeatesId = SeatesId;
    }

    public int getParksId() {
        return ParksId;
    }

    public void setParksId(int ParksId) {
        this.ParksId = ParksId;
    }
    
    
    
   
}
