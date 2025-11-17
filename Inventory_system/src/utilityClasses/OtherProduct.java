package utilityClasses;

import javax.print.attribute.standard.MediaSize;

public class OtherProduct extends Product{

    public OtherProduct(String id, String name, int quantity, int threshold, double price) {
        super(id, name, price, quantity, threshold, ProductCategory.OTHER);
    }
}
