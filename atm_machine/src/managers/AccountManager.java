package managers;

import models.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    Map<String, Account> accounts;

    public AccountManager() {
        accounts = new HashMap<>();
    }

    public Account getAccount(String accountName) {
        return accounts.get(accountName);
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
}
