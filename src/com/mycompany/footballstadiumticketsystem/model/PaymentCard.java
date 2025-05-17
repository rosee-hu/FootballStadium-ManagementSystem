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
public class PaymentCard extends Payment{

    public PaymentCard(int CardNumber, String CardName, double Amount, int PaymentId, Matchticket matchticket, Date DatePay) {
        super(PaymentId, matchticket, DatePay);
        this.CardNumber = CardNumber;
        this.CardName = CardName;
        this.Amount = Amount;
    }
   
    private int CardNumber;
    private  String CardName;
    private double Amount;

    public PaymentCard() {
    }

    
    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String CardName) {
        this.CardName = CardName;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
}
