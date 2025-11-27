package transactionHandlers;

import ATMStates.AtmStateContext;

public interface TransactionHandler {
    void handle(AtmStateContext atmStateContext, int amount);
}
