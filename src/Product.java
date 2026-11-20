// Product class - stores information about a single product
public class Product {

    // fields to store product details
    int productId;
    String productName;
    double price;
    int quantity;

    // constructor to create a new product
    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // getter methods - used to access product details
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // setter methods - used to update product details
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // display product details in a nice format
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Price: Rs. " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("---------------------------");
    }
}
