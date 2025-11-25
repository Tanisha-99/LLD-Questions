package entities;

public class Transaction {
    private User from;
    private User to;
    private Double amount;

    public Transaction(User from, User to, Double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return from.getName() + " should pay " + to.getName() + " $" + String.format("%.2f", amount);
    }
}
