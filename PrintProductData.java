/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matresssales;

/**
 *
 * @author Student
 */
public class PrintProductData {
    private IProduct productData = null;
    
    public PrintProductData (IProduct ProductData) {
    this.productData = productData;

       
    }
    public void printTotalSales() {
        System.out.println("Total Product Sales: " + productData.GetIProductsSold());
        
    }
    public void PrintAverageSales(){
        System.out.println("Average product Sales : %of%n" + productData.GetAverageProductSold());
        
    }
    public void printMostPopularProduct(){
        System.out.println("Most Popular Product Sold: " + productData.GetMostPopularProduct());
    }
    public void printReport(){
        System.out.println("\nProduct Sales Report");
        System.out.println("***********************************");
        printTotalSales();
        PrintAverageSales();
        printMostPopularProduct();
    }
    
}
