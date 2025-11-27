package ATMStates;

import models.Card;
import models.TransactionType;

public class IdleState implements AtmState{

    @Override
    public String getStateName() {
        return "Idle";
    }

    @Override
    public void insertCard(AtmStateContext atmStateContext, Card card, String pin) {
        boolean result = atmStateContext.setCard(card, pin);
        if (result) {
            atmStateContext.setCurrentState(new HasCardState());
        } else {
            System.out.println("Invalid card, Try Again!!");
        }
    }

    @Override
    public void selectOperation(AtmStateContext atmStateContext, TransactionType transactionType) {
        System.out.println("Insert card first.");
    }

    @Override
    public void withdrawCash(AtmStateContext atmStateContext, int amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void checkBalance(AtmStateContext atmStateContext) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard(AtmStateContext atmStateContext) {
        System.out.println("No card to eject.");
    }
}
