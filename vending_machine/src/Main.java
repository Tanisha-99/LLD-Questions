import managers.VendingMachine;
import productFactory.Item;
import productFactory.ItemType;
import utitlityPackage.Coin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // -------- Initialize Vending Machine --------
        VendingMachine machine = new VendingMachine(5); // 5 shelves

        // -------- Admin: Load Items --------
        System.out.println("\n--- Loading Inventory ---");
        machine.addItemToShelf(101, new Item(ItemType.COKE, 120), 5);
        machine.addItemToShelf(102, new Item(ItemType.PEPSI, 100), 4);
        machine.addItemToShelf(103, new Item(ItemType.SODA, 80), 6);

        machine.showInventory();


        System.out.println("\n======= Test Case 1: Successful Purchase =======");
        machine.insertCoin(Coin.HUNDRED);
        machine.insertCoin(Coin.TWENTY);
        machine.insertCoin(Coin.TEN);

        machine.selectItem(101);
        machine.dispense();

        machine.showInventory();


        System.out.println("\n======= Test Case 2: Refund Flow =======");
        machine.insertCoin(Coin.FIFTY);
        machine.insertCoin(Coin.FIFTY);

        machine.selectItem(103); // user changes mind
        machine.refund();

        machine.showInventory();


        System.out.println("\n======= Test Case 3: Insufficient Balance =======");
        machine.insertCoin(Coin.TEN);
        machine.selectItem(102); // price = 100
        machine.dispense();      // should refuse
        machine.refund();


        System.out.println("\n======= Test Case 4: Invalid Shelf =======");
        machine.insertCoin(Coin.HUNDRED);
        machine.selectItem(999);  // invalid shelf
        machine.refund();
    }
}

    /*
    should handle different types of products
    efficiently manage product inventory
    handle customer selection
    process payments
    dispense product


    Interaction 1:
    1. The system manages products within the vending machine
    2. Users can browse, select and purchase items.
    3. prevents dispensing out of stock items
    4. supports coin based payments
    5. Transition through different states

    Interaction 2:
    1. What types of products should the machine handle
    2. how should coin based payments be handled
    3. are there specific states to be managed



   Entities:
   1. Product
   2. Product type - enum
   3. Product Shelf
   4. Vending Machine
   5. Coin - acceptable denominations
   6. Transaction
   7. Coin dispenser

   Design patterns:
   1. Factory design pattern for product creation
   2. Strategy design pattern for payment processing - cash / UPI/ credit card
   3. state pattern for machine state transitions - ready -> item selected -> payment pending -> dispensing -> maintainance
   4. Observer pattern for refill alert to system
     */