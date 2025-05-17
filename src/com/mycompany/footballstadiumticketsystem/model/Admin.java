/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Admin extends Preson{
    
    private String Jop;

    public Admin(String Jop, int Id, String UserName, String Fname, String Lname, String Password, String Type, String Gender) {
        super(Id, UserName, Fname, Lname, Password, Type, Gender);
        this.Jop = Jop;
    }

    public Admin(String Jop) {
        this.Jop = Jop;
    }

    public Admin() {
    }

    public String getJop() {
        return Jop;
    }

    public void setJop(String Jop) {
        this.Jop = Jop;
    }

    

}
