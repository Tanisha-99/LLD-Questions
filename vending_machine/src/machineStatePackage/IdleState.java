package machineStatePackage;

import utitlityPackage.Coin;

public class IdleState implements VendingMachineState{

    @Override
    public String getStateName() {
        return "Idle";
    }

    @Override
    public void insertCoin(VendingMachineContext vendingMachineContext, Coin coin) {
        vendingMachineContext.addCoin(coin);
        vendingMachineContext.setState(new HasMoneyState());
    }

    @Override
    public void selectItem(VendingMachineContext vendingMachineContext, int shelfCode) {
        System.out.println("Cannot select item in Idle state");
    }

    @Override
    public void dispenseItem(VendingMachineContext vendingMachineContext) {
        System.out.println("Cannot dispense in Idle state");
    }

    @Override
    public void cancelItem(VendingMachineContext vendingMachineContext) {

    }
}
