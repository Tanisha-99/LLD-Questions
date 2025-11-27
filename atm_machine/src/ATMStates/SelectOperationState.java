package ATMStates;

import models.Card;
import models.TransactionType;

public class SelectOperationState implements AtmState{
    private TransactionType transactionType;

    public SelectOperationState(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String getStateName() {
        return "SelectOperation";
    }

    @Override
    public void insertCard(AtmStateContext atmStateContext, Card card, String pin) {
        System.out.println("Card already inserted");
    }

    @Override
    public void selectOperation(AtmStateContext atmStateContext, TransactionType transactionType) {
        System.out.println("Operation already selected");
    }

    @Override
    public void withdrawCash(AtmStateContext atmStateContext, int amount) {
        if (transactionType != TransactionType.CASH_WITHDRAWAL) {
            System.out.println("Invalid operation");
            return;
        }

        atmStateContext.setCurrentState(new WithdrawState());
    }

    @Override
    public void checkBalance(AtmStateContext atmStateContext) {
        if (transactionType != TransactionType.CHECK_BALANCE) {
            System.out.println("Invalid operation.");
            return;
        }

        atmStateContext.setCurrentState(new CheckBalanceState());
    }

    @Override
    public void ejectCard(AtmStateContext atmStateContext) {
        System.out.println("Card ejected.");
        atmStateContext.reset();
        atmStateContext.setCurrentState(new IdleState());
    }
}
