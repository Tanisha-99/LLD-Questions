package strategies.impl;

import strategies.PaymentStrategy;

public class UpiPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payed amount: " + amount + " by UPI");
    }
}
