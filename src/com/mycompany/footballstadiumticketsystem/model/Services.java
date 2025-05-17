/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

/**
 *
 * @author ASUS
 */
public class Services {

    public Services(int ServiceId, String ServiceName, String ServiceType,
            double Price, Categories categories) {
        this.ServiceId = ServiceId;
        this.ServiceName = ServiceName;
        this.ServiceType = ServiceType;
        this.Price = Price;
        this.categories = categories;
    }
    
    private int ServiceId;
        private String ServiceName;
         private String ServiceType;
         private double Price;
         private  Categories categories;

    public Services() {
    }

  

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int ServiceId) {
        this.ServiceId = ServiceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return  ServiceId + " " + ServiceName + " " + ServiceType + " " + Price;
    }

    
}
