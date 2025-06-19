package com.npci.bill;

import com.npci.pm.ExcelPriceMatrix;
import com.npci.pm.PriceMatrix;

/*

    design issues
    --------------

    -> tight coupling with ExcelPriceMatrix


 */

// OCP, LSP, ISP, DIP
public class DomesticBilling implements Billing {

    private PriceMatrix priceMatrix;

    public DomesticBilling(PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
    }

    public double getTotalPrice(String[] cart) {
        double totalPrice = 0.0;
        for (String item : cart) {
            double price = priceMatrix.getPrice(item);
            totalPrice += price;
        }
        return totalPrice;
    }

}
