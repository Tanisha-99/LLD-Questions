package models;

import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    Map<Cash, Integer> cashInventory;

    public CashInventory() {
        cashInventory = new HashMap<Cash, Integer>();
        initialise();
    }

    private void initialise() {
        cashInventory.put(Cash.THOUSAND, 10);
        cashInventory.put(Cash.FIVE_HUNDRED, 10);
        cashInventory.put(Cash.TWO_HUNDRED, 10);
        cashInventory.put(Cash.HUNDRED, 10);
        cashInventory.put(Cash.FIFTY, 10);
        cashInventory.put(Cash.TWENTY, 10);
        cashInventory.put(Cash.TEN, 10);
    }

    public int getTotal() {
        int total = 0;

        for(Map.Entry<Cash, Integer> entry: cashInventory.entrySet()) {
            total += entry.getKey().value * entry.getValue();
        }

        return total;
    }

    public boolean hasSufficientCash(int amount) {
        return getTotal() >= amount;
    }

    public Map<Cash, Integer> dispenseCash(int amount) {
        if(!hasSufficientCash(amount)) {
            System.out.println("Insufficient Cash at machine");
            return null;
        }

        Map<Cash, Integer> dispensedCash = new HashMap<>();
        int remainingCash = amount;

        for(Cash cash: Cash.values()) {
            int count = Math.min(remainingCash / cash.value, cashInventory.get(cash));

            if(count > 0) {
                dispensedCash.put(cash, count);
                remainingCash -= count * cash.value;
                cashInventory.put(cash, cashInventory.get(cash) - count);
            }
        }

        return dispensedCash;
    }

    public void addCash(Cash cash, int amount) {
        int existingCount = cashInventory.get(cash);
        cashInventory.put(cash, existingCount + amount);
    }
}
