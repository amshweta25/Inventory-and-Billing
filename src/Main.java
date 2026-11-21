import java.util.Scanner;

/*
 * Main class
 * ----------
 * This is the entry point of the Inventory and Billing System.
 * It shows a menu to the user and calls the appropriate methods.
 *
 * All custom exceptions are caught here using try-catch blocks.
 */
public class Main {

    public static void main(String[] args) {

        // create scanner to read user input from keyboard
        Scanner scanner = new Scanner(System.in);

        // create inventory object to manage products
        Inventory inventory = new Inventory();

        // welcome message
        System.out.println("==========================================");
        System.out.println("    INVENTORY AND BILLING SYSTEM");
        System.out.println("==========================================");
        System.out.println("Welcome! Use the menu below to manage");
        System.out.println("your inventory.");

        boolean running = true;

        // main menu loop - keeps running until user chooses to exit
        while (running) {

            // show menu options
            System.out.println("\n------------ MAIN MENU ------------");
            System.out.println("1. Add New Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Search Product by ID");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Low Stock Alerts");
            System.out.println("7. Sort Products by ID");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");

            // read user choice with input validation
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }

            // handle user choice
            switch (choice) {

                case 1:
                    // --- ADD NEW PRODUCT ---
                    try {
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter Quantity: ");
                        int qty = scanner.nextInt();

                        // validate that values are positive
                        if (id <= 0 || price < 0 || qty < 0) {
                            System.out.println("Error: Please enter positive values!");
                            break;
                        }

                        // create product and add to inventory
                        Product newProduct = new Product(id, name, price, qty);
                        inventory.addProduct(newProduct);

                    } catch (DuplicateProductException e) {
                        // our custom exception - product ID already exists
                        System.out.println("Error: " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    // --- DISPLAY ALL PRODUCTS ---
                    inventory.displayAllProducts();
                    break;

                case 3:
                    // --- UPDATE STOCK ---
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

                    } catch (ProductNotFoundException e) {
                        // our custom exception - product not found
                        System.out.println("Error: " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    // --- SEARCH PRODUCT BY ID (uses Binary Search) ---
                    try {
                        System.out.print("Enter Product ID to search: ");
                        int searchId = scanner.nextInt();

                        // uses our binary search algorithm
                        Product found = inventory.binarySearchById(searchId);
                        System.out.println("\n===== PRODUCT FOUND =====");
                        found.displayDetails();

                    } catch (ProductNotFoundException e) {
                        // our custom exception - product not found
                        System.out.println("Error: " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Invalid input! Please try again.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    // --- SEARCH PRODUCT BY NAME (uses HashMap) ---
                    try {
                        scanner.nextLine();
                        System.out.print("Enter Product Name to search: ");
                        String searchName = scanner.nextLine();

                        // uses HashMap for quick lookup
                        Product result = inventory.searchByName(searchName);
                        System.out.println("\n===== PRODUCT FOUND =====");
                        result.displayDetails();

                    } catch (ProductNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    // --- LOW STOCK ALERTS ---
                    inventory.lowStockAlert();
                    break;

                case 7:
                    // --- SORT PRODUCTS BY ID (uses Bubble Sort) ---
                    inventory.sortProductsById();
                    System.out.println("Products sorted by ID successfully!");
                    inventory.displayAllProducts();
                    break;

                case 8:
                    // --- EXIT ---
                    running = false;
                    System.out.println("\n==========================================");
                    System.out.println("  Thank you for using the system!");
                    System.out.println("  Goodbye!");
                    System.out.println("==========================================");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-8.");
            }
        }

        // close scanner to prevent resource leak
        scanner.close();
    }
}
