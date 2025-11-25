package entities;

import observer.BalanceObserver;

public class User implements BalanceObserver {
    private String id;
    private String name;
    private String email;
    private BalanceSheet balanceSheet;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balanceSheet = new BalanceSheet(this);
        this.balanceSheet.addObserver(this);
    }

    @Override
    public void balanceUpdated(User user, double amount, String message) {
        System.out.println("Notification for " + name + ": " + message + " Amount: $" + String.format("%.2f", amount));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
