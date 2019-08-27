package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    void printOwing(String name, Orders orders) {
        double totalAmount = orders.getTotalAmount();
        print(name,totalAmount);
    }   
    void print(String name,double outstanding){
        // print banner
        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}

class Orders {
    private final double[] amount;
    private double totalAmount = 0.0;
    
    public Orders(double[] amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
    	for(int i = 0;i<amount.length;i++){
    		totalAmount += amount[i];
    	}
        return totalAmount;
    }
}
