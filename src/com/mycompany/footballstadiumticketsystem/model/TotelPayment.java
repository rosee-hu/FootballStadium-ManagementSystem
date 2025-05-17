/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem.model;

/**
 *
 * @author ASUS
 */
public class TotelPayment {
    
    double PayCard;
    double PayCach;

    public TotelPayment(double PayCard, double PayCach) {
        this.PayCard = PayCard;
        this.PayCach = PayCach;
    }

    public TotelPayment() {
    }

    public double getPayCard() {
        return PayCard;
    }

    public void setPayCard(double PayCard) {
        this.PayCard = PayCard;
    }

    public double getPayCach() {
        return PayCach;
    }

    public void setPayCach(double PayCach) {
        this.PayCach = PayCach;
    }
    
}
