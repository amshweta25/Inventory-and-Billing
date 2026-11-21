// Team F: Inventory and Billing Manager
// contains stock management, invoice generator, sales report and DSA algorithms

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    // using java collections
    ArrayList<Product> prodctList = new ArrayList<Product>();
    HashMap<Integer, Product> prdMap = new HashMap<Integer, Product>();
    ArrayList<String> allInvoics = new ArrayList<String>(); // saves past bills
    
    double totelRevenue = 0.0;
    int invoiceNum = 101;

    // 1. add product to list
    public void addProdct(Product p) {
        prodctList.add(p);
        prdMap.put(p.getItmId(), p);
        System.out.println("Product added successfully!");
    }

    // 2. display all products
    public void showAllProdcts() {
        if (prodctList.size() == 0) {
            System.out.println("Inventory is empty right now.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");
        for (int i = 0; i < prodctList.size(); i++) {
            prodctList.get(i).printDetails(); // polymorphism in action
        }
    }

    // 3. update stock
    public void updatStock(int pid, int newStk) throws ProductNotFoundException {
        Product p = prdMap.get(pid);
        if (p == null) {
            throw new ProductNotFoundException("Product with ID " + pid + " does not exist!");
        }
        p.setQuanty(newStk);
        System.out.println("Stock updated successfully!");
    }

    // 4. low stock alert
    public void checkLowStok() {
        System.out.println("\n--- Low Stock Alert (Less than 5) ---");
        boolean anyLow = false;
        for (int i = 0; i < prodctList.size(); i++) {
            if (prodctList.get(i).getQuanty() < 5) {
                prodctList.get(i).printDetails();
                anyLow = true;
            }
        }
        if (!anyLow) {
            System.out.println("All items have safe stock level.");
        }
    }

    // 5. invoice generation and billing
    public void generateInvois(String custmrName, int pid, int buyQty) throws ProductNotFoundException, NotEnoughStockException {
        Product p = prdMap.get(pid);
        if (p == null) {
            throw new ProductNotFoundException("Product ID " + pid + " not found!");
        }

        if (buyQty > p.getQuanty()) {
            throw new NotEnoughStockException("Only " + p.getQuanty() + " items available in stock!");
        }

        // deduct quantity from stock
        p.setQuanty(p.getQuanty() - buyQty);
        double billAmount = buyQty * p.getItmPrice();
        totelRevenue = totelRevenue + billAmount;

        // print bill on screen
        System.out.println("\n======= INVOICE #" + invoiceNum + " =======");
        System.out.println("Customer Name : " + custmrName);
        System.out.println("Item Bought   : " + p.getItmName());
        System.out.println("Rate per item : Rs " + p.getItmPrice());
        System.out.println("Quantity      : " + buyQty);
        System.out.println("Total Amount  : Rs " + billAmount);
        System.out.println("Remaining Stk : " + p.getQuanty());
        System.out.println("================================");

        // store record for sales report
        String billRecord = "Inv #" + invoiceNum + " | Customer: " + custmrName + " | Item: " + p.getItmName() + " | Qty: " + buyQty + " | Rs " + billAmount;
        allInvoics.add(billRecord);
        invoiceNum++;
    }

    // 6. sales report
    public void showSalesRepport() {
        System.out.println("\n======= SALES REPORT =======");
        if (allInvoics.size() == 0) {
            System.out.println("No sales made yet.");
            return;
        }
        for (int i = 0; i < allInvoics.size(); i++) {
            System.out.println(allInvoics.get(i));
        }
        System.out.println("----------------------------");
        System.out.println("Total Revenue Earned: Rs " + totelRevenue);
        System.out.println("============================");
    }

    // 7. DSA: Bubble sort implementation to arrange products by id
    public void bubbleSortProds() {
        int n = prodctList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (prodctList.get(j).getItmId() > prodctList.get(j + 1).getItmId()) {
                    // swap items
                    Product temp = prodctList.get(j);
                    prodctList.set(j, prodctList.get(j + 1));
                    prodctList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Products sorted by ID using bubble sort!");
    }

    // 8. DSA: Binary search implementation to find product by id
    public Product binrySearchProd(int targetId) throws ProductNotFoundException {
        // sort first before binary search
        bubbleSortProds();

        int low = 0;
        int high = prodctList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int curId = prodctList.get(mid).getItmId();

            if (curId == targetId) {
                return prodctList.get(mid);
            } else if (curId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // if not found
        throw new ProductNotFoundException("Product with ID " + targetId + " was not found!");
    }
}
