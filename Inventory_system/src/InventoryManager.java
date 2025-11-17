import observerPackage.InventoryObserver;
import productFactoryPackage.ProductFactory;
import replenishmentStrategyPackage.ReplenishmentStrategy;
import utilityClasses.Product;
import utilityClasses.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private static InventoryManager inventoryManager;
    private Map<String, Warehouse> warehouses;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;
    private List<InventoryObserver> observers;

    private InventoryManager() {
        this.warehouses = new HashMap<>();
        productFactory = new ProductFactory();
        this.observers = new ArrayList<>();
    }

    // synchronised so that at a time only 1 thread can run this method
    // the lock is on the class object not on instance
    public static synchronized InventoryManager getInstance() {
        if(inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }

        return inventoryManager;
    }

    public void addWarehouse(Warehouse warehouse) {
        this.warehouses.put(warehouse.getId(), warehouse);
    }

    public void removeWarehouse(String warehouseId) {
        if(this.warehouses.containsKey(warehouseId)) {
            this.warehouses.remove(warehouseId);
        }
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    private Product getProductById(String productId) {
        for(Warehouse warehouse : this.warehouses.values()) {
            Product product = warehouse.getProductById(productId);

            if(product != null) {
                return product;
            }
        }

        return null;
    }

    public void checkAndReplenish(String productId) {
        Product product = getProductById(productId);
        if(product != null) {
            if(product.getQuantity() < product.getThreshold()) {
                if(this.replenishmentStrategy != null) {
                    this.replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    //Global check across all warehouses.
    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses.values()) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    if (replenishmentStrategy != null)  replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Product product) {
        for(InventoryObserver observer : observers) {
            observer.update(product);
        }
    }

}
