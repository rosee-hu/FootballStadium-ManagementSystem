/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.util.ArrayList;
import javax.xml.crypto.Data;

/**
 *
 * @author ASUS
 */
public class Ticket {
    private int TicketId;
    private String Type;
    private double Price;
    private  int NumberOfTickts;
    private MatchFootball football;

    public Ticket(int TicketId, String Type, double Price, MatchFootball football) {
        this.TicketId = TicketId;
        this.Type = Type;
        this.Price = Price;
        this.football = football;
    }

    public Ticket(int TicketId, String Type, double Price, int NumberOfTickts, MatchFootball football) {
        this.TicketId = TicketId;
        this.Type = Type;
        this.Price = Price;
        this.NumberOfTickts = NumberOfTickts;
        this.football = football;
    }

    public int getNumberOfTickts() {
        return NumberOfTickts;
    }

    public void setNumberOfTickts(int NumberOfTickts) {
        this.NumberOfTickts = NumberOfTickts;
    }
    
  

   

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int TicketId) {
        this.TicketId = TicketId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public MatchFootball getFootball() {
        return football;
    }

    public void setFootball(MatchFootball football) {
        this.football = football;
    }
   
    


    public Ticket() {
    }

    
    

}
