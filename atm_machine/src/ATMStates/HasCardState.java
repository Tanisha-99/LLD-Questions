package ATMStates;

import models.Card;
import models.TransactionType;

public class HasCardState implements AtmState {
    @Override
    public String getStateName() {
        return "HasCardState";
    }

    @Override
    public void insertCard(AtmStateContext atmStateContext, Card card, String pin) {
        System.out.println("Card is already inserted");
    }

    @Override
    public void selectOperation(AtmStateContext atmStateContext, TransactionType transactionType) {
        if (transactionType == null) {
            System.out.println("Invalid option.");
            return;
        }
        atmStateContext.setCurrentState(new SelectOperationState(transactionType));
    }

    @Override
    public void withdrawCash(AtmStateContext atmStateContext, int amount) {
        System.out.println("Select operation first.");
    }

    @Override
    public void checkBalance(AtmStateContext atmStateContext) {
        System.out.println("Select operation first.");
    }

    @Override
    public void ejectCard(AtmStateContext atmStateContext) {
        System.out.println("Card ejected.");
        atmStateContext.reset();
        atmStateContext.setCurrentState(new IdleState());
    }
}
