package machineStatePackage;

import productFactory.Item;
import productFactory.ItemShelf;
import utitlityPackage.Coin;

public class DispenseState implements VendingMachineState{
    @Override
    public String getStateName() {
        return "DispenseState";
    }

    @Override
    public void insertCoin(VendingMachineContext vendingMachineContext, Coin coin) {
        System.out.println("Cannot insert coins while dispensing");
    }

    @Override
    public void selectItem(VendingMachineContext vendingMachineContext, int shelfCode) {
        System.out.println("Already dispensing");
    }

    @Override
    public void dispenseItem(VendingMachineContext vendingMachineContext) {
        int code = vendingMachineContext.getSelectedShelf();
        if (code == 0) {
            System.out.println("No item selected");
            return;
        }
        Item item = vendingMachineContext.getInventory().dispenseItem(code);
        System.out.println("Dispensed: " + item.getItemType());
        // compute and return change
        int balance = vendingMachineContext.getBalanceInCents();
        int change = balance - item.getPrice();
        if (change > 0) {
            System.out.println("Returning change (in cents): " + change);
            vendingMachineContext.returnAmountAsCoins(change); // simple helper to print/return coins
        }
        vendingMachineContext.resetTransaction();
        // if inventory empty overall -> OutOfStock else Idle
        if (!vendingMachineContext.getInventory().hasItems()) {
            vendingMachineContext.setState(new OutOfStockState());
        } else {
            vendingMachineContext.setState(new IdleState());
        }
    }

    @Override
    public void cancelItem(VendingMachineContext vendingMachineContext) {
        System.out.println("Cannot cancel while dispensing");
    }
}
