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
        System.out.println("Welcome! Use the menu below to manage");
        System.out.println("your inventory.");

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
            System.out.print("Enter your choice (1-6): ");

            // read user choice with validation
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            // process user choice using switch
            switch (choice) {

                case 1:
                    // add new product
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // clear the buffer

                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter Quantity: ");
                        int qty = scanner.nextInt();

                        // check for valid values
                        if (id <= 0 || price < 0 || qty < 0) {
                            System.out.println("Error: Please enter positive values!");
                            break;
                        }

                        // create new product and add to inventory
                        Product newProduct = new Product(id, name, price, qty);
                        inventory.addProduct(newProduct);

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine(); // clear invalid input
                    }
                    break;

                case 2:
                    // display all products
                    inventory.displayAllProducts();
                    break;

                case 3:
                    // update stock quantity
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int updateId = scanner.nextInt();

                        System.out.print("Enter new quantity: ");
                        int newQty = scanner.nextInt();

                        if (newQty < 0) {
                            System.out.println("Error: Quantity cannot be negative!");
                            break;
                        }

                        inventory.updateStock(updateId, newQty);

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    // search product by ID
                    try {
                        System.out.print("Enter Product ID to search: ");
                        int searchId = scanner.nextInt();

                        inventory.searchProduct(searchId);

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    // display low stock alerts
                    inventory.lowStockAlert();
                    break;

                case 6:
                    running = false;
                    System.out.println("\n======================================");
                    System.out.println("  Thank you for using the system!");
                    System.out.println("  Goodbye!");
                    System.out.println("======================================");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }
        }

        // close scanner
        scanner.close();
    }
}
