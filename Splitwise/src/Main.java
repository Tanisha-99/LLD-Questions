import controllers.SplitwiseManager;
import entities.Expense;
import entities.Group;
import entities.Transaction;
import entities.User;
import strategy.EqualSplitStrategy;
import strategy.ExactSplitStrategy;
import strategy.PercentageSplitStrategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // 1. Setup the splitwiseManager
        SplitwiseManager splitwiseManager = SplitwiseManager.getInstance();

        // 2. Create users and groups
        User alice = splitwiseManager.addUser("user1", "Alice", "alice@a.com");
        User bob = splitwiseManager.addUser( "user2", "Bob", "bob@b.com");
        User charlie = splitwiseManager.addUser("user3", "Charlie", "charlie@c.com");
        User david = splitwiseManager.addUser("user4", "David", "david@d.com");

        Group friendsGroup = splitwiseManager.addGroup("Friends Trip", List.of(alice, bob, charlie, david));

        System.out.println("--- System Setup Complete ---\n");

        // 3. Use Case 1: Equal Split
        System.out.println("--- Use Case 1: Equal Split ---");
        splitwiseManager.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Dinner")
                .setAmount(1000.0)
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(alice, bob, charlie, david))
                .setSplitStrategy(new EqualSplitStrategy())
        );

        splitwiseManager.showBalanceSheet(alice.getId());
        splitwiseManager.showBalanceSheet(bob.getId());
        System.out.println();

        // 4. Use Case 2: Exact Split
        System.out.println("--- Use Case 2: Exact Split ---");
        splitwiseManager.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Movie Tickets")
                .setAmount(370.0)
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(bob, charlie))
                .setSplitStrategy(new ExactSplitStrategy())
                .setSplitValues(Arrays.asList(120.0, 250.0))
        );

        splitwiseManager.showBalanceSheet(alice.getId());
        splitwiseManager.showBalanceSheet(bob.getId());
        System.out.println();

        // 5. Use Case 3: Percentage Split
        System.out.println("--- Use Case 3: Percentage Split ---");
        splitwiseManager.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Groceries")
                .setAmount(500.0)
                .setPaidBy(david)
                .setParticipants(Arrays.asList(alice, bob, charlie))
                .setSplitStrategy(new PercentageSplitStrategy())
                .setSplitValues(Arrays.asList(40.0, 30.0, 30.0)) // 40%, 30%, 30%
        );

        System.out.println("--- Balances After All Expenses ---");
        splitwiseManager.showBalanceSheet(alice.getId());
        splitwiseManager.showBalanceSheet(bob.getId());

        splitwiseManager.showBalanceSheet(charlie.getId());
        splitwiseManager.showBalanceSheet(david.getId());

        System.out.println();

        // 6. Use Case 4: Simplify Group Debts
        System.out.println("--- Use Case 4: Simplify Group Debts for 'Friends Trip' ---");
        List<Transaction> simplifiedDebts = splitwiseManager.simplifyGroupDebts(friendsGroup.getId());
        if (simplifiedDebts.isEmpty()) {
            System.out.println("All debts are settled within the group!");
        } else {
            simplifiedDebts.forEach(System.out::println);
        }
        System.out.println();

        splitwiseManager.showBalanceSheet(bob.getId());

        // 7. Use Case 5: Partial Settlement
        System.out.println("--- Use Case 5: Partial Settlement ---");
        // From the simplified debts, we see Bob should pay Alice. Let's say Bob pays 100.
        splitwiseManager.settleUp(bob, alice, 100.0);

        System.out.println("--- Balances After Partial Settlement ---");
        splitwiseManager.showBalanceSheet(alice.getId());
        splitwiseManager.showBalanceSheet(bob.getId());
    }
}

/*
Entities:

1. User
2. Group
3. Expense
4. Split
5. Split Type - equal / percantage / custom
6. Balance sheet
7. Splitwise - the controller
8. Transaction

Design pattern:

1. Strategy pattern for split type
2. Observer to notify
3. Builder for expense
 */