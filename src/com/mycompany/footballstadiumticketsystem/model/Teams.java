/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Teams {
    
    
    private int TeamID;
    private String TeamName;

    private Date DateOfEstablishment;
    private String Loaction;

    public Teams(int TeamID, String TeamName, Date DateOfEstablishment, String Loaction) {
        this.TeamID = TeamID;
        this.TeamName = TeamName;
        this.DateOfEstablishment = DateOfEstablishment;
        this.Loaction = Loaction;
    }
    
  


    public Date getDateOfEstablishment() {
        return DateOfEstablishment;
    }

    public void setDateOfEstablishment(Date
            DateOfEstablishment) {
        this.DateOfEstablishment = DateOfEstablishment;
    }

    public String getLoaction() {
        return Loaction;
    }

    public void setLoaction(String Loaction) {
        this.Loaction = Loaction;
    }
    
    
    public Teams() {
    }

    public Teams(int TeamID, String TeamName) {
        this.TeamID = TeamID;
        this.TeamName = TeamName;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int TeamID) {
        this.TeamID = TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }
    
    
}
