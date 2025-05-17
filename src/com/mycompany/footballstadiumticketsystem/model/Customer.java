/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Customer extends Preson{

    private String Address;

    private String Phone;
    private int age;

   
    public Customer( String Fname, String Lname,String Address, String Phone,
            int age, int Id, String UserName,
           String Password, String Type, String Gender) {
        super(Id, UserName, Fname, Lname, Password, Type, Gender);
        this.Address = Address;
        this.Phone = Phone;
        this.age = age;
    }

    /**
     *
     * @param Address
     * @param Phone
     * @param age
     * @param Id
     * @param UserName
     * @param Fname
     * @param Lname
     * @param Password
     */
    public Customer(String Address, String Phone, int age) {   
        this.Address = Address;
        this.Phone = Phone;
        this.age = age;
    }

    public Customer() {
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


   

  

}
