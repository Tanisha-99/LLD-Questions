package services;

import entities.Account;
import entities.Transaction;
import repositories.AccountRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class WalletService {
    private final UserRepository userRepo;
    private final AccountRepository accountRepo;
    private final TransactionRepository txRepo;
    private final CurrencyService currencyService;
    public WalletService(UserRepository u, AccountRepository a, TransactionRepository t, CurrencyService c) {
        this.userRepo = u;
        this.accountRepo = a;
        this.txRepo = t;
        this.currencyService = c;
    }


    public void transfer(String fromId, String toId, BigDecimal amount) {
        try {
            Account from = accountRepo.getAccountById(fromId);
            Account to = accountRepo.getAccountById(toId);


            /*
            ordering matters to avoid deadlock
            lets say t1 locks a1 first and tries to lock a2
            lets say t2 locks a2 first and tries to lock a1

            so deadlock condition
             */

            List<Account> ordered = List.of(from, to).stream().sorted(Comparator.comparing(Account::getAccountId)).toList();

            ordered.get(0).getLock().lock();
            ordered.get(1).getLock().lock();

            try {
                BigDecimal converted = currencyService.convert(amount, from.getCurrency(), to.getCurrency());
                if (from.getBalance().compareTo(amount) < 0) {
                    throw new RuntimeException("Insufficient funds");
                }

                from.debit(amount);
                to.credit(converted);

                txRepo.save(new Transaction(UUID.randomUUID().toString(), fromId, toId, amount));
            } finally {
                ordered.get(1).getLock().unlock();
                ordered.get(0).getLock().unlock();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
