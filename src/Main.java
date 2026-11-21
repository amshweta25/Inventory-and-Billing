// Team F: Main class for running the console application
// Simple menu-driven program for high school project

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory myInv = new Inventory();

        System.out.println("******************************************");
        System.out.println("   TEAM F: INVENTORY & BILLING SYSTEM");
        System.out.println("******************************************");

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n--- MENU OPTIONS ---");
            System.out.println("1. Add New Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Search Product by ID (Binary Search)");
            System.out.println("5. Check Low Stock Alerts");
            System.out.println("6. Generate Invoice (Billing)");
            System.out.println("7. View Sales Report");
            System.out.println("8. Sort Products by ID (Bubble Sort)");
            System.out.println("9. Exit");
            System.out.print("Enter your choise (1-9): ");

            int userChoise = 0;
            try {
                userChoise = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (userChoise) {
                case 1:
                    // add product
                    try {
                        System.out.print("Enter Product ID: ");
                        int pid = sc.nextInt();
                        sc.nextLine(); // clear line

                        System.out.print("Enter Product Name: ");
                        String pname = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double prc = sc.nextDouble();

                        System.out.print("Enter Quantity: ");
                        int qnty = sc.nextInt();

                        if (pid <= 0 || prc <= 0 || qnty < 0) {
                            System.out.println("Error: Negative or zero values not allowed!");
                            break;
                        }

                        Product newP = new Product(pid, pname, prc, qnty);
                        myInv.addProdct(newP);
                    } catch (Exception e) {
                        System.out.println("Wrong input given! Try again.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    // display all
                    myInv.showAllProdcts();
                    break;

                case 3:
                    // update stock
                    try {
                        System.out.print("Enter Product ID to update: ");
                        int upId = sc.nextInt();

                        System.out.print("Enter New Quantity: ");
                        int newQ = sc.nextInt();

                        if (newQ < 0) {
                            System.out.println("Quantity cannot be negative!");
                            break;
                        }

                        myInv.updatStock(upId, newQ);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Custom Exception: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    // binary search product
                    try {
                        System.out.print("Enter Product ID to search: ");
                        int srchId = sc.nextInt();

                        Product found = myInv.binrySearchProd(srchId);
                        System.out.println("\nProduct Found:");
                        found.printDetails();
                    } catch (ProductNotFoundException e) {
                        System.out.println("Custom Exception: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;

                case 5:
                    // low stock alert
                    myInv.checkLowStok();
                    break;

                case 6:
                    // generate invoice (billing)
                    try {
                        sc.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String cName = sc.nextLine();

                        System.out.print("Enter Product ID to buy: ");
                        int buyId = sc.nextInt();

                        System.out.print("Enter Quantity to buy: ");
                        int buyQ = sc.nextInt();

                        if (buyQ <= 0) {
                            System.out.println("Buying quantity must be greater than 0!");
                            break;
                        }

                        myInv.generateInvois(cName, buyId, buyQ);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Custom Exception: " + e.getMessage());
                    } catch (NotEnoughStockException e) {
                        System.out.println("Custom Exception: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Billing error: Invalid input.");
                        sc.nextLine();
                    }
                    break;

                case 7:
                    // sales report
                    myInv.showSalesRepport();
                    break;

                case 8:
                    // bubble sort
                    myInv.bubbleSortProds();
                    myInv.showAllProdcts();
                    break;

                case 9:
                    // exit
                    keepRunning = false;
                    System.out.println("\nThank you for using Team F System. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose between 1 to 9.");
            }
        }

        sc.close();
    }
}
