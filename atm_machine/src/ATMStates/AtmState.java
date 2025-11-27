package ATMStates;

import models.Card;
import models.TransactionType;

public interface AtmState {
    String getStateName();

    void insertCard(AtmStateContext atmStateContext, Card card, String pin);

    void selectOperation(AtmStateContext atmStateContext, TransactionType transactionType);

    void withdrawCash(AtmStateContext atmStateContext, int amount);

    void checkBalance(AtmStateContext atmStateContext);

    void ejectCard(AtmStateContext context);
}
