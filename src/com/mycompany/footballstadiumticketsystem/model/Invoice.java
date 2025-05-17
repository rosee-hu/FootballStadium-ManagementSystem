/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

/**
 *
 * @author ASUS
 */
public class Invoice {
    
    private int InvoiceId;
    
    private Matchticket matchticket;
    
    private Services services;
    private  int Count;

    public Invoice(int InvoiceId, Matchticket matchticket, Services services, int Count) {
        this.InvoiceId = InvoiceId;
        this.matchticket = matchticket;
        this.services = services;
        this.Count = Count;
    }

    public Invoice(int InvoiceId, Services services, int Count) {
        this.InvoiceId = InvoiceId;
        this.services = services;
        this.Count = Count;
    }

    public Invoice() {
    }

  
    public int getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(int InvoiceId) {
        this.InvoiceId = InvoiceId;
    }

    public Matchticket getMatchticket() {
        return matchticket;
    }

    public void setMatchticket(Matchticket matchticket) {
        this.matchticket = matchticket;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

   
}
