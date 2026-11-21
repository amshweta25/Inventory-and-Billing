/*
 * Product class
 * -------------
 * This class represents a single product in the inventory.
 * It EXTENDS the Item class (Inheritance) and provides its own
 * version of displayDetails() (Polymorphism).
 *
 * OOP Concepts used:
 * - INHERITANCE: Product extends Item (gets id, name, price from Item)
 * - ENCAPSULATION: quantity is private, accessed only through getters/setters
 * - POLYMORPHISM: displayDetails() is overridden from Item class
 */
public class Product extends Item {

    // private field - only this class can access it directly (encapsulation)
    private int quantity;

    // constructor - calls parent constructor using super() for id, name, price
    public Product(int productId, String productName, double price, int quantity) {
        super(productId, productName, price);  // calling Item's constructor
        this.quantity = quantity;
    }

    // getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
     * POLYMORPHISM - this method overrides the abstract method from Item class.
     * The @Override annotation tells Java that we are providing our own version
     * of a method that was declared in the parent class.
     */
    @Override
    public void displayDetails() {
        System.out.println("Product ID   : " + getId());
        System.out.println("Product Name : " + getName());
        System.out.println("Price        : Rs. " + getPrice());
        System.out.println("Quantity     : " + quantity);
        System.out.println("---------------------------");
    }
}
