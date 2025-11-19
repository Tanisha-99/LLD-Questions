package machineStatePackage;

import productFactory.Item;
import productFactory.ItemShelf;
import utitlityPackage.Coin;

public class HasMoneyState implements VendingMachineState{

    @Override
    public String getStateName() {
        return "HasMoney";
    }

    @Override
    public void insertCoin(VendingMachineContext vendingMachineContext, Coin coin) {
        vendingMachineContext.addCoin(coin);
    }

    @Override
    public void selectItem(VendingMachineContext vendingMachineContext, int shelfCode) {
        ItemShelf itemShelf = vendingMachineContext.getInventory().getItemShelf(shelfCode);

        if(itemShelf.isEmpty()) {
            System.out.println("Selected shelf is empty");
            return;
        }

        Item item = itemShelf.getItem();
        int balance = vendingMachineContext.getBalanceInCents();

        if(balance < item.getPrice()) {
            System.out.println("Insufficient funds");
            return;
        }

        vendingMachineContext.setSelectedShelf(shelfCode);
        vendingMachineContext.setState(new DispenseState());
    }

    @Override
    public void dispenseItem(VendingMachineContext vendingMachineContext) {
        System.out.println("Select an item before dispensing");
    }

    @Override
    public void cancelItem(VendingMachineContext vendingMachineContext) {
        vendingMachineContext.refundCoins();
        vendingMachineContext.resetTransaction();
        vendingMachineContext.setState(new IdleState());
    }
}
