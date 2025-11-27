package ATMStates;

import models.Card;
import models.TransactionType;

public class CheckBalanceState implements AtmState{
    @Override
    public String getStateName() {
        return "CheckBalance";
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
        System.out.println("Invalid option");
    }

    @Override
    public void checkBalance(AtmStateContext atmStateContext) {
        atmStateContext.getHandlerFactory()
                .getHandler(TransactionType.CHECK_BALANCE)
                .handle(atmStateContext, 0);
    }

    @Override
    public void ejectCard(AtmStateContext context) {
        System.out.println("Card ejected.");
        context.reset();
        context.setCurrentState(new IdleState());
    }
}
