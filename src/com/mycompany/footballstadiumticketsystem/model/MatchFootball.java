/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ASUS
 */
public class MatchFootball {
 
    private int MatchNumber;
        private Teams Home_Team;
    private Teams Away_Team;
    private Date DateMatch;
    private Time TimeMatch;
    private int Status;
    private Stadiums StadiumID;

    public MatchFootball(int MatchNumber, 
            Teams Home_Team, Teams Away_Team, Date DateMatch, Time TimeMatch, int Status, Stadiums StadiumID) {
        this.MatchNumber = MatchNumber;
        this.Home_Team = Home_Team;
        this.Away_Team = Away_Team;
        this.DateMatch = DateMatch;
        this.TimeMatch = TimeMatch;
        this.Status = Status;
        this.StadiumID = StadiumID;
    }

  

    public MatchFootball() {
    }

    public int getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(int MachNumber) {
        this.MatchNumber = MachNumber;
    }

    public Teams getHome_Team() {
        return Home_Team;
    }

    public void setHome_Team(Teams Home_Team) {
        this.Home_Team = Home_Team;
    }

    public Teams getAway_Team() {
        return Away_Team;
    }

    public void setAway_Team(Teams Away_Team) {
        this.Away_Team = Away_Team;
    }

    public Date getDateMatch() {
        return DateMatch;
    }

    public void setDateMach(Date DateMatch) {
        this.DateMatch = DateMatch;
    }

    public Time getTimeMatch() {
        return TimeMatch;
    }

    public void setTimeMatch(Time TimeMatch) {
        this.TimeMatch = TimeMatch;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Stadiums getStadiumID() {
        return StadiumID;
    }

    public void setStadiumID(Stadiums StadiumID) {
        this.StadiumID = StadiumID;
    }
 
}
