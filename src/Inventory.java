import java.util.ArrayList;
import java.util.HashMap;

/*
 * Inventory class
 * ----------------
 * This class manages all the products in the inventory.
 * It uses:
 * - ArrayList to store products in order (Collections)
 * - HashMap for quick lookup of products by name (Collections)
 * - Custom exceptions for error handling
 *
 * Collections used: ArrayList, HashMap
 */
public class Inventory {

    // ArrayList to store all products in order
    private ArrayList<Product> productList;

    // HashMap for quick search by product name
    // Key = product name (lowercase), Value = product object
    private HashMap<String, Product> productMap;

    // threshold for low stock warning
    private int lowStockLimit = 5;

    // constructor - initializes the collections
    public Inventory() {
        productList = new ArrayList<>();
        productMap = new HashMap<>();
    }

    /*
     * Method to add a new product to inventory.
     * Throws DuplicateProductException if product ID already exists.
     */
    public void addProduct(Product product) throws DuplicateProductException {

        // check if product with same ID already exists
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                throw new DuplicateProductException(
                    "Product with ID " + product.getId() + " already exists!"
                );
            }
        }

        // add product to both ArrayList and HashMap
        productList.add(product);
        productMap.put(product.getName().toLowerCase(), product);
        System.out.println("Product '" + product.getName() + "' added successfully!");
    }

    // method to display all products in inventory
    public void displayAllProducts() {

        if (productList.size() == 0) {
            System.out.println("No products in inventory!");
            return;
        }

        System.out.println("\n===== ALL PRODUCTS IN INVENTORY =====");
        for (int i = 0; i < productList.size(); i++) {
            // calling displayDetails() - polymorphism in action
            // Java calls Product's version of this method
            productList.get(i).displayDetails();
        }
    }

    /*
     * Method to update stock quantity.
     * Throws ProductNotFoundException if the product does not exist.
     */
    public void updateStock(int productId, int newQuantity) throws ProductNotFoundException {

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == productId) {
                productList.get(i).setQuantity(newQuantity);
                System.out.println("Stock updated successfully!");
                return;
            }
        }

        // product was not found, throw custom exception
        throw new ProductNotFoundException(
            "Product with ID " + productId + " not found!"
        );
    }

    /*
     * DSA IMPLEMENTATION: Bubble Sort
     * --------------------------------
     * This method sorts the product list by Product ID in ascending order.
     * We wrote this sorting algorithm ourselves instead of using Collections.sort().
     *
     * HOW BUBBLE SORT WORKS:
     * - Compare two adjacent products
     * - If the first one has a bigger ID, swap them
     * - Repeat until the entire list is sorted
     * - After each pass, the largest unsorted element "bubbles up" to its correct position
     */
    public void sortProductsById() {

        int n = productList.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                // compare IDs of adjacent products
                if (productList.get(j).getId() > productList.get(j + 1).getId()) {

                    // swap the two products
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }

    /*
     * DSA IMPLEMENTATION: Binary Search
     * -----------------------------------
     * This method searches for a product by ID using binary search.
     * Binary search is much faster than checking every product one by one.
     *
     * IMPORTANT: The list must be sorted before binary search works!
     * That is why we call sortProductsById() first.
     *
     * HOW BINARY SEARCH WORKS:
     * - Look at the middle product
     * - If its ID matches, we found it
     * - If the target ID is smaller, search the left half
     * - If the target ID is bigger, search the right half
     * - Repeat until found or nothing is left
     *
     * Throws ProductNotFoundException if product is not found.
     */
    public Product binarySearchById(int productId) throws ProductNotFoundException {

        // first sort the list so binary search works correctly
        sortProductsById();

        int low = 0;
        int high = productList.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int midId = productList.get(mid).getId();

            if (midId == productId) {
                // found the product!
                return productList.get(mid);

            } else if (midId < productId) {
                // target is in the right half
                low = mid + 1;

            } else {
                // target is in the left half
                high = mid - 1;
            }
        }

        // product not found, throw custom exception
        throw new ProductNotFoundException(
            "Product with ID " + productId + " not found!"
        );
    }

    /*
     * Search product by name using HashMap.
     * HashMap gives us instant lookup instead of looping through the whole list.
     * Throws ProductNotFoundException if the name is not found.
     */
    public Product searchByName(String name) throws ProductNotFoundException {

        // convert to lowercase for case-insensitive search
        Product product = productMap.get(name.toLowerCase());

        if (product == null) {
            throw new ProductNotFoundException(
                "Product with name '" + name + "' not found!"
            );
        }

        return product;
    }

    // method to display low stock alerts
    public void lowStockAlert() {

        System.out.println("\n===== LOW STOCK ALERTS =====");
        System.out.println("Products with quantity less than " + lowStockLimit + ":");
        System.out.println("---------------------------");

        boolean found = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getQuantity() < lowStockLimit) {
                productList.get(i).displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("All products have sufficient stock!");
        }
    }
}
