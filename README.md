# Inventory and Billing System

A simple Java console-based application for managing inventory and billing.

## Features
1. **Add Products and Manage Stock** - Add new products with ID, name, price, and quantity. Update stock levels anytime.
2. **Low Stock Alerts** - View products that have quantity below 5 units.
3. **Search Products** - Search for any product using its unique Product ID (Binary Search) or by name (HashMap lookup).

## OOP Concepts Used
- **Encapsulation** - All fields are private. Access is only through getter and setter methods.
- **Inheritance** - Product class extends the abstract Item class.
- **Abstraction** - Item is an abstract class with an abstract method displayDetails().
- **Polymorphism** - Product overrides the displayDetails() method from Item class.

## Custom Exceptions
- **ProductNotFoundException** - Thrown when a product is not found during search or update.
- **DuplicateProductException** - Thrown when trying to add a product with an existing ID.

## DSA Implementation
- **Bubble Sort** - Custom sorting algorithm to sort products by Product ID.
- **Binary Search** - Custom search algorithm to find products by ID efficiently.

## Collections Used
- **ArrayList** - To store all products in order.
- **HashMap** - For quick product lookup by name.

## How to Run

1. Open terminal and go to the `src` folder:
   ```
   cd src
   ```

2. Compile all Java files:
   ```
   javac Item.java Product.java ProductNotFoundException.java DuplicateProductException.java Inventory.java Main.java
   ```

3. Run the program:
   ```
   java Main
   ```

## Menu Options
| Option | Description |
|--------|-------------|
| 1 | Add a new product (enter ID, name, price, quantity) |
| 2 | Display all products in inventory |
| 3 | Update stock quantity of an existing product |
| 4 | Search for a product by ID (uses Binary Search) |
| 5 | Search for a product by Name (uses HashMap) |
| 6 | View low stock alerts (products with quantity < 5) |
| 7 | Sort all products by ID (uses Bubble Sort) |
| 8 | Exit the program |

## Project Structure
```
Inventory-and-Billing/
├── README.md
└── src/
    ├── Item.java                        - Abstract base class (Abstraction)
    ├── Product.java                     - Product class (Inheritance, Polymorphism)
    ├── Inventory.java                   - Inventory management (Bubble Sort, Binary Search, HashMap)
    ├── ProductNotFoundException.java    - Custom exception for missing products
    ├── DuplicateProductException.java   - Custom exception for duplicate IDs
    └── Main.java                        - Main class with menu and exception handling
```
