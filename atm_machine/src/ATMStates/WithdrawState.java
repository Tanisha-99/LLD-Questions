package ATMStates;

import models.Card;
import models.TransactionType;

public class WithdrawState implements AtmState{
    @Override
    public String getStateName() {
        return "Withdraw";
    }

    @Override
    public void insertCard(AtmStateContext atmStateContext, Card card, String pin) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void selectOperation(AtmStateContext atmStateContext, TransactionType transactionType) {
        System.out.println("Operation already in progress.");
    }

    @Override
    public void withdrawCash(AtmStateContext atmStateContext, int amount) {
        atmStateContext.getHandlerFactory()
                .getHandler(TransactionType.CASH_WITHDRAWAL)
                .handle(atmStateContext, amount);
    }

    @Override
    public void checkBalance(AtmStateContext atmStateContext) {
        System.out.println("Invalid operation");
    }

    @Override
    public void ejectCard(AtmStateContext atmStateContext) {
        System.out.println("Card ejected.");
        atmStateContext.reset();
        atmStateContext.setCurrentState(new IdleState());
    }
}
