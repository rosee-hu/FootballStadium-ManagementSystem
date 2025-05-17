/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Payment {
    
    private int PaymentId;
    private Matchticket matchticket;
    private Date DatePay;

    public Payment(int PaymentId, Matchticket matchticket, Date DatePay) {
        this.PaymentId = PaymentId;
        this.matchticket = matchticket;
        this.DatePay = DatePay;
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(int PaymentId) {
        this.PaymentId = PaymentId;
    }

    public Matchticket getMatchticket() {
        return matchticket;
    }

    public void setMatchticket(Matchticket matchticket) {
        this.matchticket = matchticket;
    }

    public Date getDatePay() {
        return DatePay;
    }

    public void setDatePay(Date DatePay) {
        this.DatePay = DatePay;
    }

    public Payment() {
    }

   
    
}
