package models;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {

        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if(balance < amount) {
            System.out.println("Insufficient Balance");
            return false;
        }

        balance -= amount;
        return true;
    }
}
