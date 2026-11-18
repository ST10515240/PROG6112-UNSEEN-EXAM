/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matresssales;

/**
 *
 * @author Student
 */
public class ProductCalculations {
    private static double VAT_RATE = 0.15;
    private static double COMMISSION_RATE = 0.05;
    private double productPrice;
    
    Product ProductCalculations(double productPrice){
        this.productPrice = productPrice;
        return null;
        
    }
    public double GetVat() {
        return productPrice * VAT_RATE;
        
    }
    public double GetCommission(){
        return productPrice * COMMISSION_RATE;
        
        
    }
    public double GetTotal(){
        return productPrice + GetVat() + GetCommission();
       
    }
    
}
