package controllers;

import entities.Expense;
import entities.Split;
import entities.User;

public class ExpenseManager {
    public synchronized void createExpense(Expense.ExpenseBuilder builder) throws IllegalAccessException {
        Expense expense = builder.build();
        User paidBy = expense.getPaidBy();

        for(Split split: expense.getSplits()) {
            User participant = split.getUser();
            Double amount = split.getAmount();

            if(!paidBy.equals(participant)) {
                paidBy.getBalanceSheet().adjustBalance(participant, amount);
                participant.getBalanceSheet().adjustBalance(paidBy, -amount);
            }
        }

        System.out.println("Expense " + expense.getDescription() + " of amount " + expense.getAmount() + " created");
    }

    public synchronized void settleUp(User payer, User payee, Double amount) {
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());
        payer.getBalanceSheet().adjustBalance(payee, amount);
        payee.getBalanceSheet().adjustBalance(payer, -amount);
    }
}
