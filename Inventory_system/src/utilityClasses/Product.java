package utilityClasses;

public abstract class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory productCategory;

    public Product(String id, String name, double price, int quantity, int threshold, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
        this.productCategory = productCategory;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
