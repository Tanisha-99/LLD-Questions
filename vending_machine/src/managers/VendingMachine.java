package managers;

import machineStatePackage.VendingMachineContext;
import productFactory.Item;
import utitlityPackage.Coin;

import java.util.List;

public class VendingMachine {
    private Inventory inventory;
    private VendingMachineContext vendingMachineContext;

    public VendingMachine(int initialShelfCount) {
        this.inventory = new Inventory(initialShelfCount);
        this.vendingMachineContext = new VendingMachineContext(inventory);
    }

    public void insertCoin(Coin coin) {
        vendingMachineContext.getCurrentState().insertCoin(vendingMachineContext, coin);
    }

    public void selectItem(int shelfCode) {
        vendingMachineContext.getCurrentState().selectItem(vendingMachineContext, shelfCode);
    }

    public void dispense() {
        vendingMachineContext.getCurrentState().dispenseItem(vendingMachineContext);
    }

    public void refund() {
        vendingMachineContext.getCurrentState().cancelItem(vendingMachineContext);
    }

    public void addItemToShelf(int shelfCode, Item item, int count) {
        inventory.addItem(shelfCode, item, count);
    }

    public void showInventory() {
//        inventory.getShelvesSnapshot().forEach((code, shelf) -> {
//            var it = shelf.getItem();
//            System.out.println("Shelf " + code + ": " +
//                    (it == null ? "EMPTY" : it.getType() + " x" + shelf.getQuantity()));
//        });
    }
}
