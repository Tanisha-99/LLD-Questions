package machineStatePackage;

import utitlityPackage.Coin;

public class OutOfStockState implements VendingMachineState{
    @Override
    public String getStateName() {
        return "OutOfStock";
    }

    @Override
    public void insertCoin(VendingMachineContext vendingMachineContext, Coin coin) {

    }

    @Override
    public void selectItem(VendingMachineContext vendingMachineContext, int shelfCode) {

    }

    @Override
    public void dispenseItem(VendingMachineContext vendingMachineContext) {

    }

    @Override
    public void cancelItem(VendingMachineContext vendingMachineContext) {

    }
}
