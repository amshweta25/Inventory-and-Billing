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
                    System.out.println("Add Product - Coming Soon");
                    break;

                case 2:
                    System.out.println("Display Products - Coming Soon");
                    break;

                case 3:
                    System.out.println("Update Stock - Coming Soon");
                    break;

                case 4:
                    System.out.println("Search Product - Coming Soon");
                    break;

                case 5:
                    System.out.println("Low Stock Alert - Coming Soon");
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
