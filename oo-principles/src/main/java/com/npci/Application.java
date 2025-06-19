package com.npci;

import com.npci.bill.Billing;
import com.npci.bill.DomesticBilling;
import com.npci.pm.ExcelPriceMatrix;
import com.npci.pm.PriceMatrix;

public class Application {

    public static void main(String[] args) {

        PriceMatrix excelPriceMatrix = new ExcelPriceMatrix();// dependency
        Billing domesticBilling = new DomesticBilling(excelPriceMatrix); // dependet , injecting dependency

        String[] cart1 = {"123", "456", "789"};
        double totalPrice = domesticBilling.getTotalPrice(cart1);
        System.out.println("Total Price for cart1: " + totalPrice);

        String[] cart2 = {"123", "456", "789", "101112"};
        double totalPrice2 = domesticBilling.getTotalPrice(cart2);
        System.out.println("Total Price for cart2: " + totalPrice2);


    }

}
