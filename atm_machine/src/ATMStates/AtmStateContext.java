package ATMStates;

import managers.AccountManager;
import transactionHandlers.HandlerFactory;
import models.Card;
import models.CashInventory;

public class AtmStateContext {
    private AtmState currentState;
    private Card card;
    private AccountManager accountManager;
    private CashInventory cashInventory;
    private HandlerFactory handlerFactory;

    public AtmStateContext(AccountManager accountManager, CashInventory cashInventory) {
        currentState = new IdleState();
        card = null;
        this.accountManager = accountManager;
        this.cashInventory = cashInventory;
        this.handlerFactory = new HandlerFactory();
    }

    public AtmState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AtmState currentState) {
        this.currentState = currentState;
    }

    public HandlerFactory getHandlerFactory() {
        return handlerFactory;
    }

    public Card getCard() {
        return card;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public CashInventory getCashInventory() {
        return cashInventory;
    }

    public boolean setCard(Card card, String pin) {
        if(card.isCardValid() && card.isCardAuthenticated(pin)) {
            this.card = card;
            return true;
        }
        return false;
    }

    public void reset() {
        card = null;
    }
}
