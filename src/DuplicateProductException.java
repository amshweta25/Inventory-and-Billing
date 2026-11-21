/*
 * Custom Exception: DuplicateProductException
 * ---------------------------------------------
 * This exception is thrown when we try to add a product
 * with an ID that already exists in the inventory.
 *
 * This prevents duplicate entries in our inventory system.
 */
public class DuplicateProductException extends Exception {

    // constructor - takes a message explaining the error
    public DuplicateProductException(String message) {
        super(message);  // pass the message to the parent Exception class
    }
}
