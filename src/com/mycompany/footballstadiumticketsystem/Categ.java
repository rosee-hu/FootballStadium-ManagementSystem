package com.mycompany.footballstadiumticketsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Categ {
     private int CategorieId;
    private String CategorieName;

    public Categ(int CategorieId, String CategorieName) {
        this.CategorieId = CategorieId;
        this.CategorieName = CategorieName;
    }

   

   
    public Categ() {
    }

    Categ(String category_1) {
                this.CategorieName = category_1;

    }

    public int getCategorieId() {
        return CategorieId;
    }

    public void setCategorieId(
            int CategorieId) {
        this.CategorieId = CategorieId;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(
            String CategorieName) {
        this.CategorieName = CategorieName;
    }
    
}
