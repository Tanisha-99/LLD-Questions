package entities;

import observer.BalanceObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private User owner;

    // positive value means owner has to take money from user
    //negative value means owner has to give money to user
    private Map<User, Double> balances;
    private List<BalanceObserver> observers;

    public BalanceSheet(User user) {
        this.owner = user;
        this.balances = new ConcurrentHashMap<>();
        this.observers = new ArrayList<>();
    }

    public synchronized void adjustBalance(User user, Double amount) {
        if(owner.equals(user)) {
            return;
        }

        balances.merge(user, amount, Double::sum);
        notifyObservers(user, amount, "Balance updated with " + user.getName());
    }

    public void addObserver(BalanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BalanceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(User user, Double amount, String message) {
        for (BalanceObserver observer : observers) {
            observer.balanceUpdated(user, amount, message);
        }
    }

    public void showBalance() {
        System.out.println("Balance sheet for: " + owner.getName());
        if(balances.isEmpty()) {
            System.out.println("All settled up");
            return;
        }

        Double totalOwedToMe = 0.0;
        Double totalIOwe = 0.0;

        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            User otherUser = entry.getKey();
            Double amount = entry.getValue();

            if (amount > 0.01) {
                System.out.println(otherUser.getName() + " owes " + owner.getName() + " $" + String.format("%.2f", amount));
                totalOwedToMe += amount;
            } else if (amount < -0.01) {
                System.out.println(owner.getName() + " owes " + otherUser.getName() + " $" + String.format("%.2f", -amount));
                totalIOwe += (-amount);
            }
        }
        System.out.println("Total Owed to " + owner.getName() + ": $" + String.format("%.2f", totalOwedToMe));
        System.out.println("Total " + owner.getName() + " Owes: $" + String.format("%.2f", totalIOwe));
        System.out.println("---------------------------------");
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
