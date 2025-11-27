import entities.Account;
import entities.Currency;
import entities.User;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DigitalWalletService digitalWalletService = DigitalWalletService.getInstance();

        User u1 = new User("U1", "user1");
        User u2 = new User("U2", "user2");

        digitalWalletService.addUser(u1);
        digitalWalletService.addUser(u2);

        Account a1 = new Account("A1", "U1", Currency.INR);
        Account a2 = new Account("A2", "U2", Currency.USD);

        digitalWalletService.addAccount(a1);
        digitalWalletService.addAccount(a2);
        digitalWalletService.credit("A1", new BigDecimal("10000"));

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
                digitalWalletService.transfer(new BigDecimal("100"), "A1", "A2");
            });
        }


        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);


        System.out.println("Final Balance A1: " + a1.getBalance());
        System.out.println("Final Balance A2: " + a2.getBalance());
    }
}

/*
Requirements:

1. users can create an account and manage personal info

skip
2. users can add and remove payment methods, such as credit card, bank account

3. system should support fund transfer between users and bank account

skip
4. system should handle transaction history and provide a statement of transaction

5. The digital wallet should handle concurrent transactions and ensure data consistency.

skip
6. The system should ensure the security of user information and transactions.

7. should support multiple currencies and perform currency conversions

Entities:

1. User
2. account
3. Balance sheet
4. Transaction
5. Currency - enum
6. digit wallet

Design patterns:

1. Strategy for payment methods.
2. Singleton
3. Observer

 */