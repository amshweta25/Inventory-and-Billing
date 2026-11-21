/*
 * Custom Exception: ProductNotFoundException
 * -------------------------------------------
 * This exception is thrown when we try to search, update or delete
 * a product that does not exist in the inventory.
 *
 * WHY CUSTOM EXCEPTION? Instead of printing error messages everywhere,
 * we throw this exception and catch it in one place. This is cleaner
 * and follows good Java practices.
 */
public class ProductNotFoundException extends Exception {

    // constructor - takes a message explaining what went wrong
    public ProductNotFoundException(String message) {
        super(message);  // pass the message to the parent Exception class
    }
}
