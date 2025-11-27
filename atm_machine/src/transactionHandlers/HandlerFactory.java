package transactionHandlers;

import models.TransactionType;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {
    private final Map<TransactionType, TransactionHandler> handlers = new HashMap<>();

    public HandlerFactory() {
        handlers.put(TransactionType.CASH_WITHDRAWAL, new WithdrawHandler());
        handlers.put(TransactionType.CHECK_BALANCE, new CheckBalanceHandler());
    }

    public TransactionHandler getHandler(TransactionType type) {
        return handlers.get(type);
    }
}

