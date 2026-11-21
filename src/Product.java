// Team F: Product child class
// Product inherits from Item (Inheritance)

public class Product extends Item {
    private int quanty; // stock quantity of product

    public Product(int pId, String pName, double pPrce, int qnty) {
        super(pId, pName, pPrce);
        this.quanty = qnty;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    // overriding parent method (polymorphism)
    @Override
    public void printDetails() {
        System.out.println("ID: " + getItmId() + " | Name: " + getItmName() + " | Price: Rs " + getItmPrice() + " | Stock: " + quanty);
    }
}
