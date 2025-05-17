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
public class Categories {
    
    private int CategorieId;
    private String CategorieName;

    public Categories(int CategorieId, String CategorieName) {
        this.CategorieId = CategorieId;
        this.CategorieName = CategorieName;
    }

   

   Categories(String category_1) {
                this.CategorieName = category_1;

    }
    public Categories() {
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

    @Override
    public String toString() {
        return "" + CategorieId + " " + CategorieName + ' ';
    }
    
    
    
}
