package machineStatePackage;

import managers.Inventory;
import utitlityPackage.Coin;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineContext {
    private VendingMachineState currentState;
    private final Inventory inventory;
    private List<Coin> coins;
    private int selectedShelfCode;

    public VendingMachineContext(Inventory inventory) {
        this.inventory = inventory;
        currentState = new IdleState();
        coins = new ArrayList<>();
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

   public void setState(VendingMachineState vendingMachineState) {
        currentState = vendingMachineState;
   }

    void addCoin(Coin coin) { coins.add(coin); }

    int getBalanceInCents() {
        return coins.stream().mapToInt(c -> c.value).sum();
    }

    void refundCoins() {
        int amount = getBalanceInCents();
        if (amount > 0) {
            System.out.println("Refund: " + amount + " cents");
            coins.clear();
        }
    }

    void returnAmountAsCoins(int amount) {

    }

    void resetTransaction() {
        coins.clear();
        selectedShelfCode = 0;
    }

    Inventory getInventory() {
        return inventory;
    }

    int getSelectedShelf() {
        return selectedShelfCode;
    }

    void setSelectedShelf(int code) {
        selectedShelfCode = code;
    }
}
