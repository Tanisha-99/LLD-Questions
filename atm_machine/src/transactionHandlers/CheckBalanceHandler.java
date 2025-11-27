package transactionHandlers;

import ATMStates.AtmStateContext;
import models.Account;

public class CheckBalanceHandler implements TransactionHandler {

    public void handle(AtmStateContext atmStateContext, int amount) {
        Account account = atmStateContext.getAccountManager()
                .getAccount(atmStateContext.getCard().getAccountNumber());

        System.out.println("Balance = " + account.getBalance());

        atmStateContext.getCurrentState().ejectCard(atmStateContext);
    }
}

