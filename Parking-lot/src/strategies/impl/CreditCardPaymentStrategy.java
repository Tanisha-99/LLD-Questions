package strategies.impl;

import strategies.PaymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payed amount: " + amount + " by credit card");
    }
}
