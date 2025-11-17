import productFactoryPackage.ProductFactory;
import replenishmentStrategyPackage.JustInTimeReplenishmentStrategy;
import replenishmentStrategyPackage.ReplenishmentStrategy;
import utilityClasses.Product;
import utilityClasses.ProductCategory;
import utilityClasses.Warehouse;

import java.time.Instant;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to Inventory System!");

        ReplenishmentStrategy replenishmentStrategy = new JustInTimeReplenishmentStrategy();
        InventoryManager inventoryManager = InventoryManager.getInstance();
        ProductFactory productFactory = new ProductFactory();

        //create and add warehouses
        Warehouse warehouse1 = new Warehouse("1", "warehouse1", "location1");
        Warehouse warehouse2 = new Warehouse("2", "warehouse2", "location2");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        //create products
        Product laptop = productFactory.createProduct(ProductCategory.ELECTRONICS, "laptop1", "laptop1", 10000, 3,2, "Mac", 1, Date.from(Instant.now()), false, "black", null);
        Product tshirt = productFactory.createProduct(ProductCategory.CLOTHING, "tshirt1", "tshirt1", 500, 3,2, "H&M", 1, Date.from(Instant.now()), false, "black", null);
        Product apple = productFactory.createProduct(ProductCategory.GROCERY, "apple1", "apple", 100, 3,2, "Mac", 1, Date.from(Instant.now()), false, "black", null);

        warehouse1.addProduct(laptop);
        warehouse1.addProduct(tshirt);
        warehouse1.addProduct(apple);

        inventoryManager.setReplenishmentStrategy(replenishmentStrategy);

        inventoryManager.performInventoryCheck();

    }
}


/*
tracks, manages, optimize product inventory - handles multiple products. tracks stock levels, processes orders, ensures timely replenishment.
- supports various products
- inventory operations like add, remove transfer
- provides real time alerts for low stocks
- generate inventory reports


Requirements:
1. A system with multiple warehouses & product categories
2. stock level tracking and management
3. intelligent replenishment strategy implementation
4. handling edge cases like damaged inventory or returns


Entities:
1. product
2. product category - enum
3. warehouse
4. inventory manager - we just want one inventory manager to be there hence singleton pattern
5. Inventory operation - enum

Design patterns:
1. Singleton pattern for inventory management
2. strategy pattern for replenishment
3. factory pattern for product creation
4. observer pattern for notifying
 */