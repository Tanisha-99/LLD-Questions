package utilityClasses;

import java.util.UUID;

public class ElectronicsProducts extends Product{

    private String brand;
    private int warrantyPeriod;

    public ElectronicsProducts(String id, String name, String brand, int warrantyPeriod, double price, int quantity, int threshold) {
        super(id, name, price, quantity, threshold, ProductCategory.ELECTRONICS);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
