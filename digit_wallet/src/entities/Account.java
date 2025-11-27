package entities;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final String accountId;
    private final String userId;
    private BigDecimal balance;
    private Currency currency;
    private final ReentrantLock lock;

    public Account(String accountId, String userId, Currency currency) {
        this.accountId = accountId;
        this.userId = userId;
        this.currency = currency;
        this.balance = BigDecimal.ZERO;
        this.lock = new ReentrantLock();
    }

    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getAccountId() {
        return accountId;
    }
}
