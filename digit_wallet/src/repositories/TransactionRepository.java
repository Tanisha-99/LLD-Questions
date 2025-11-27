package repositories;

import entities.Transaction;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionRepository {
    private final List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new CopyOnWriteArrayList<>();
    }

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransaction() {
        return transactions;
    }
}
