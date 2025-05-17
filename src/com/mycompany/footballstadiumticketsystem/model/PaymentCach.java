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
public class PaymentCach extends Payment{

    public PaymentCach(double Amount, int PaymentId, Matchticket matchticket, Date DatePay) {
        super(PaymentId, matchticket, DatePay);
        this.Amount = Amount;
    }

    public PaymentCach() {
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
   
    private double Amount;

    
    
    
}
