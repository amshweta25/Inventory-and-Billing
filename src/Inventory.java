import java.util.ArrayList;

// Inventory class - manages the list of all products
public class Inventory {

    // ArrayList to store all products
    ArrayList<Product> productList = new ArrayList<>();

    // method to add a new product to inventory
    public void addProduct(Product product) {

        // check if product with same ID already exists
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == product.getProductId()) {
                System.out.println("Error: Product with ID " + product.getProductId() + " already exists!");
                return;
            }
        }

        // add the product to the list
        productList.add(product);
        System.out.println("Product added successfully!");
    }
}
