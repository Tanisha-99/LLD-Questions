package strategies.impl;

import strategies.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {

    public CashPaymentStrategy() {

    }

    @Override
    public void pay(double amount) {
        System.out.println("Payed amount: " + amount + " by cash");
    }
}
