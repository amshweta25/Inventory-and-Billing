// Team F: Base abstract class for items
// shows abstraction concept

public abstract class Item {
    // keeping variables private for encapsulation
    private int itmId;
    private String itmName;
    private double itmPrice;

    // constructor
    public Item(int itmId, String itmName, double itmPrice) {
        this.itmId = itmId;
        this.itmName = itmName;
        this.itmPrice = itmPrice;
    }

    public int getItmId() {
        return itmId;
    }

    public String getItmName() {
        return itmName;
    }

    public double getItmPrice() {
        return itmPrice;
    }

    public void setItmPrice(double newPrce) {
        this.itmPrice = newPrce;
    }

    // abstract method to be overridden by child class (polymorphism)
    public abstract void printDetails();
}
