import java.util.Scanner;

// Main class - entry point of the application
public class Main {

    public static void main(String[] args) {

        // create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // create inventory object
        Inventory inventory = new Inventory();

        System.out.println("======================================");
        System.out.println("  INVENTORY AND BILLING SYSTEM");
        System.out.println("======================================");

        // variable to control the loop
        boolean running = true;

        // main menu loop
        while (running) {

            // display menu options
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add New Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Search Product by ID");
            System.out.println("5. Low Stock Alerts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // read user choice
            int choice = scanner.nextInt();

            // process user choice using switch
            switch (choice) {

                case 1:
                    // add new product
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear the buffer

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    // create new product and add to inventory
                    Product newProduct = new Product(id, name, price, qty);
                    inventory.addProduct(newProduct);
                    break;

                case 2:
                    // display all products
                    inventory.displayAllProducts();
                    break;

                case 3:
                    // update stock quantity
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();

                    inventory.updateStock(updateId, newQty);
                    break;

                case 4:
                    // search product by ID
                    System.out.print("Enter Product ID to search: ");
                    int searchId = scanner.nextInt();

                    inventory.searchProduct(searchId);
                    break;

                case 5:
                    // display low stock alerts
                    inventory.lowStockAlert();
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using Inventory System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        // close scanner
        scanner.close();
    }
}
