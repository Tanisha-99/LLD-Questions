package managers;

import productFactory.Item;
import productFactory.ItemShelf;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
   Map<Integer, ItemShelf> inventory;
   private int nextShelfCode;

    public Inventory(int itemCount) {
        this.inventory = new HashMap<Integer, ItemShelf>();
        this.nextShelfCode = 101;
        initialiseEmptyInventory(itemCount);
    }

    private void initialiseEmptyInventory(int itemCount) {
        for(int i = 0; i < itemCount; i++) {
            ItemShelf itemShelf = new ItemShelf(nextShelfCode);
            inventory.put(nextShelfCode, itemShelf);
            nextShelfCode++;
        }
    }

    public ItemShelf addItemShelf() {
        ItemShelf itemShelf = new ItemShelf(nextShelfCode);
        inventory.put(nextShelfCode, itemShelf);
        nextShelfCode++;
        return itemShelf;
    }

    public ItemShelf getItemShelf(int itemCode) {
        return inventory.get(itemCode);
    }


    //this could have been done in inventory manager
    public void addItem(int code, Item item, int quantity) {
        if(inventory.containsKey(code)) {
            ItemShelf itemShelf = inventory.get(code);
            itemShelf.addItem(item, quantity);
        }
        else {
            System.out.println("Item shelf: " + code + " not found");
        }
    }

    public Item dispenseItem(int code) {
        if(inventory.containsKey(code)) {
            ItemShelf itemShelf = inventory.get(code);
            return itemShelf.dispenseItem();
        }
        System.out.println("Item shelf: " + code + " not found");
        return null;
    }

    public boolean hasItems() {
        for(ItemShelf itemShelf : inventory.values()){
            if(!itemShelf.isEmpty()) return true;
        }
        return false;
    }
}
