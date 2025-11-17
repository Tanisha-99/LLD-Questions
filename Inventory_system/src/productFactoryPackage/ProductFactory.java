package productFactoryPackage;

import utilityClasses.*;

import java.util.Date;
import java.util.UUID;

public class ProductFactory {

    public static Product createProduct(ProductCategory productCategory, String id, String name, double price, int quantity, int threshold, String brand, int warrantyPeriod, Date expiryDate, boolean isRefrigerated,String colour, String size)
    {
        switch(productCategory) {
            case ELECTRONICS:
                return new ElectronicsProducts(id, name, brand, warrantyPeriod, price, quantity, threshold);
            case CLOTHING:
                return new ClothingProduct(id, colour, size, name, price, quantity, threshold);
            case GROCERY:
                return new GroceryProduct(id, expiryDate, isRefrigerated, name, quantity, threshold, price);
            default:
                return new OtherProduct(id, name, quantity, threshold, price);
        }
    }
}
