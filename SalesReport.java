/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matresssales;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class SalesReport {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        
        //1D Array storing the three top performing matress names
        String[] 
        products = {
        "Cozy Nights Monarch",
        "Restonic Barbados" ,
        "Sealy Phuket"
    };
        //2D Array stroring sales for 3 products across 3 months
        // According to Farrell (2019), a two-dimensional array uses two subscripts to represent rows and columns//
    int [][] sales = new int[products.length][3];
    
    //Capture sales input from user
    for(int i = 0; i < products.length; i++){
        for (int month = 0; month < 3; month++){
            System.out.println("Enter number of sales for month " +(month + 1)+ "for" + products[i] + "matress: ");
            sales[i][month] = scanner.nextInt();
        }
    }
    
           
    
}
}
