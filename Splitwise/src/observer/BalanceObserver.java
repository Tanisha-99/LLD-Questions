package observer;

import entities.User;

public interface BalanceObserver {
    void balanceUpdated(User user, double amount, String message);
}
