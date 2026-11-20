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

    // method to display all products in inventory
    public void displayAllProducts() {

        // check if inventory is empty
        if (productList.size() == 0) {
            System.out.println("No products in inventory!");
            return;
        }

        System.out.println("\n===== ALL PRODUCTS IN INVENTORY =====");
        // loop through all products and display them
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).displayProduct();
        }
    }

    // method to update stock quantity of a product
    public void updateStock(int productId, int newQuantity) {

        // search for the product by ID
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                productList.get(i).setQuantity(newQuantity);
                System.out.println("Stock updated successfully!");
                return;
            }
        }

        // if product not found
        System.out.println("Error: Product with ID " + productId + " not found!");
    }

    // method to search for a product using product ID
    public void searchProduct(int productId) {

        // loop through all products to find matching ID
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                System.out.println("\n===== PRODUCT FOUND =====");
                productList.get(i).displayProduct();
                return;
            }
        }

        // if product not found
        System.out.println("Product with ID " + productId + " not found!");
    }
}
