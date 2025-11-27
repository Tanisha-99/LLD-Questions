package repositories;

import entities.Account;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountRepository {
    private final Map<String, Account> accounts;


    public AccountRepository() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public void save(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public Account getAccountById(String accountId) throws Exception {
        if(!accounts.containsKey(accountId)) {
            throw new Exception("Account not found");
        }

        return accounts.get(accountId);
    }

    public void credit(String accountId, BigDecimal amount) throws Exception {
        if(!accounts.containsKey(accountId)) {
            throw new Exception("Account not found");
        }

        Account account = getAccountById(accountId);
        account.credit(amount);
    }
}
