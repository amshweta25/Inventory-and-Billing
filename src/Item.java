/*
 * Item class (Abstract)
 * ---------------------
 * This is the base class for all items in the inventory.
 * It is abstract, meaning you cannot create an object of Item directly.
 * Any class that extends Item must provide its own version of displayDetails().
 *
 * WHY ABSTRACT? Because every type of item (Product, etc.) will have
 * its own way of displaying details. This forces subclasses to implement it.
 *
 * OOP Concept: ABSTRACTION - hides complex details and shows only what is needed.
 */
public abstract class Item {

    // fields are PRIVATE - this is ENCAPSULATION
    // no one outside this class can directly access these variables
    private int id;
    private String name;
    private double price;

    // constructor - sets the basic details of any item
    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // getter methods - the only way to read private fields from outside
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // setter method for price
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Abstract method - has no body here.
     * Every subclass MUST write its own version of this method.
     * This is what makes this class abstract.
     */
    public abstract void displayDetails();
}
