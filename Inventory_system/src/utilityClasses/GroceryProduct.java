package utilityClasses;

import java.util.Date;
import java.util.UUID;

import static utilityClasses.ProductCategory.GROCERY;

public class GroceryProduct extends Product{

    private Date expiry;
    private boolean isRefrigerated;

    public GroceryProduct(String id, Date expiry, boolean isRefrigerated, String name, int quantity, int threshold, double price) {
        super(id, name, price, quantity, threshold, GROCERY);
        this.expiry = expiry;
        this.isRefrigerated = isRefrigerated;
    }

    public Date getExpiry() {
        return expiry;
    }

    public boolean isRefrigerated() {
        return isRefrigerated;
    }
}
