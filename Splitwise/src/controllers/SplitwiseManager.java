package controllers;

import entities.Expense;
import entities.Group;
import entities.Transaction;
import entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseManager {
    private static SplitwiseManager splitwiseManager;
    private UserManager userManager;
    private GroupManager groupManager;
    private ExpenseManager expenseManager;

    private SplitwiseManager() {
        this.userManager = new UserManager();
        this.groupManager = new GroupManager();
        this.expenseManager = new ExpenseManager();
    }

    public static synchronized SplitwiseManager getInstance() {
        if(splitwiseManager == null) {
            splitwiseManager = new SplitwiseManager();
        }

        return splitwiseManager;
    }

    public User addUser(String id, String name, String email) {
        return userManager.addUser(id, name, email);
    }

    public Group addGroup(String name, List<User> members) {
        return groupManager.addGroup(name, members);
    }

    public User getUser(String id) {
        return userManager.getUser(id);
    }

    public Group getGroup(String id) {
        return groupManager.getGroup(id);
    }

    public synchronized void createExpense(Expense.ExpenseBuilder builder) throws IllegalAccessException {
        expenseManager.createExpense(builder);
    }

    public synchronized void settleUp(User payer, User payee, Double amount) {
        expenseManager.settleUp(payer, payee, amount);
    }

    public List<Transaction> simplifyGroupDebts(String groupId) {
        return groupManager.simplifyGroupDebts(groupId);
    }

    public void showBalanceSheet(String userId) {
        userManager.showBalanceSheet(userId);
    }
}
