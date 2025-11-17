package utilityClasses;

import java.util.UUID;

public class ClothingProduct extends Product{

    private String colour;
    private String size;

    public ClothingProduct(String id, String colour, String size, String name, double price, int quantity, int threshold) {
        super(id, name, price, quantity, threshold, ProductCategory.CLOTHING);
        this.colour = colour;
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public String getSize() {
        return size;
    }
}
