// Team F - Custom Exception 1
// thrown if product is missing
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
