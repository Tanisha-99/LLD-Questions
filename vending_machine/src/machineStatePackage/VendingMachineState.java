package machineStatePackage;

import utitlityPackage.Coin;

public interface VendingMachineState {

    String getStateName();

    void insertCoin(VendingMachineContext vendingMachineContext, Coin coin);

    void selectItem(VendingMachineContext vendingMachineContext, int shelfCode);

    void dispenseItem(VendingMachineContext vendingMachineContext);

    void cancelItem(VendingMachineContext vendingMachineContext);
}
