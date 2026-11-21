// Team F - Custom Exception 2
// thrown if customer wants more items than present in stock
public class NotEnoughStockException extends Exception {
    public NotEnoughStockException(String msg) {
        super(msg);
    }
}
