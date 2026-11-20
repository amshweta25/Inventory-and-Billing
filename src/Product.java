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
}
