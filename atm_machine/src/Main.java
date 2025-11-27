import ATMStates.AtmStateContext;
import managers.AccountManager;
import models.Account;
import models.Card;
import models.CashInventory;
import models.TransactionType;

import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        CashInventory cashInventory = new CashInventory();

        Account account1 = new Account("ACC123");
        account1.deposit(5000);
        accountManager.addAccount(account1);

        Card card = new Card("ABC", "CARD123", new Date(System.currentTimeMillis() + 86400000), "1234", "ACC123");

        AtmStateContext atmStateContext = new AtmStateContext(accountManager, cashInventory);

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert your card...");
        atmStateContext.getCurrentState().insertCard(atmStateContext, card, "1234");

        System.out.println("Choose operation (1 - Withdraw, 2 - Check Balance): ");
        int option = sc.nextInt();
        TransactionType type = TransactionType.getTypeFromOption(option);

        atmStateContext.getCurrentState().selectOperation(atmStateContext, type);

        if (type == TransactionType.CASH_WITHDRAWAL) {
            System.out.println("Enter amount:");
            int amount = sc.nextInt();
            atmStateContext.getCurrentState().withdrawCash(atmStateContext, amount);
        } else {
            atmStateContext.getCurrentState().checkBalance(atmStateContext);
        }
    }
}


/*
   manage banking operations
   authenticate users
   process transactions - withdraw / deposit / view balance / change pin / printing passbook
   manage cash inventory
   Atm state - idle, has card, select operation, cash withdraw, check balance,


   First interaction:
   1. The system processes customer transactions on a single ATM
   2. Users insert cards, authenticate and perform operations
   3. Users are verifies using PIN before transactions
   4. ATM maintains cash inventory
   5. System cycles through various operational states.

   Clarifying questions:
   1. What operations should be supported
   2. How is user authentication handled
   3. What states should the ATM manage

   Entities:
   1. ATM machine
   2. User
   3. Account
   4. Card
   5. Cash - enum representing denominations
   6. ATM inventory
   7. Transaction type

   Design patterns:
   1. State design pattern
   2. Observer pattern for alerting admin and user
   3. Strategy for authentication
 */