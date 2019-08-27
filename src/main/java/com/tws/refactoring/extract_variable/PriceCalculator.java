package com.tws.refactoring.extract_variable;

public class PriceCalculator {
	int baseQuantity = 500 ;
	double discount
    double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        return quantity * itemPrice -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
    }
}
