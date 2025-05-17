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
public class Preson {
    
    private int Id;
    private String UserName;
    private String Fname;
    private String Lname;
    private String Password;
    private String Type;
    private String Gender;

    public Preson(int Id, String UserName, String Fname, String Lname, String Password, String Type, String Gender) {
        this.Id = Id;
        this.UserName = UserName;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Password = Password;
        this.Type = Type;
        this.Gender = Gender;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

   

  

    public Preson() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

  
}
