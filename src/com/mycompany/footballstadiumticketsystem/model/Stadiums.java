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
public class Stadiums {
    private int StadiumID;
    private String StadiumName;
    private String City;
    private int NumberOfSeates;
    private int NumberOfParks;

    public Stadiums(int StadiumID, String StadiumName, String City, int NumberOfSeates, int NumberOfParks) {
        this.StadiumID = StadiumID;
        this.StadiumName = StadiumName;
        this.City = City;
        this.NumberOfSeates = NumberOfSeates;
        this.NumberOfParks = NumberOfParks;
    }

    public Stadiums() {
    }

    public int getStadiumID() {
        return StadiumID;
    }

    public void setStadiumID(int StadiumID) {
        this.StadiumID = StadiumID;
    }

    public String getStadiumName() {
        return StadiumName;
    }

    public void setStadiumName(String StadiumName) {
        this.StadiumName = StadiumName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getNumberOfSeates() {
        return NumberOfSeates;
    }

    public void setNumberOfSeates(int NumberOfSeates) {
        this.NumberOfSeates = NumberOfSeates;
    }

    public int getNumberOfParks() {
        return NumberOfParks;
    }

    public void setNumberOfParks(int NumberOfParks) {
        this.NumberOfParks = NumberOfParks;
    }
    

  
   
}
