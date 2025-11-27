package transactionHandlers;

import ATMStates.AtmStateContext;
import models.Account;

public class WithdrawHandler implements TransactionHandler {

    public void handle(AtmStateContext atmStateContext, int amount) {

        Account account = atmStateContext.getAccountManager()
                .getAccount(atmStateContext.getCard().getAccountNumber());

        if(account.getBalance() < amount) {
            System.out.println("Insufficient funds");
            atmStateContext.getCurrentState().ejectCard(atmStateContext);
            return;
        }

        if(!atmStateContext.getCashInventory().hasSufficientCash(amount)) {
            System.out.println("ATM out of cash");
            atmStateContext.getCurrentState().ejectCard(atmStateContext);
            return;
        }

        account.withdraw(amount);
        atmStateContext.getCashInventory().dispenseCash(amount);

        System.out.println("Withdraw successful");

        atmStateContext.getCurrentState().ejectCard(atmStateContext);
    }
}

