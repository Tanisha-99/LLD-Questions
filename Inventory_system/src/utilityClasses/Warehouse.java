package utilityClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private String id;
    private String name;
    private String location;
    private Map<String, Product> products; // id -> Product

    public Warehouse(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.products = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void addProduct(Product product) {
        String id = product.getId();

        if(products.containsKey(id)) {
            Product existingProduct = products.get(id);
            existingProduct.setQuantity(product.getQuantity());
        }

        products.put(id, product);
    }

    public boolean removeProduct(String id, int quantity) {
        if(products.containsKey(id)) {
            Product existingProduct = products.get(id);
            int currentQuantity = existingProduct.getQuantity();
            if(currentQuantity >= quantity) {
                existingProduct.setQuantity(currentQuantity - quantity);

                if(existingProduct.getQuantity() == 0) {
                    products.remove(id);
                }

                return true;
            } else {
                System.out.println("Insufficient quantity");
                return false;

            }
        }

        System.out.println("Product: " + id + " does not exist");
        return false;
    }

    public int getAvailableQuantity(String id) {
        if (products.containsKey(id)) {
            return products.get(id).getQuantity();
        }
        return 0; // Product not found
    }

    public Product getProductById(String id) {
        if(products.containsKey(id)) {
            return products.get(id);
        }

        return null;
    }

    public List<Product> getAllProducts() {
        return products.values().stream().toList();
    }
}
