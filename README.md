# Inventory and Billing System

A simple Java console-based application for managing inventory and billing.

## Features
1. **Add Products and Manage Stock** - Add new products with ID, name, price, and quantity. Update stock levels anytime.
2. **Low Stock Alerts** - View products that have quantity below 5 units.
3. **Search Products** - Search for any product using its unique Product ID.

## How to Run

1. Open terminal and go to the `src` folder:
   ```
   cd src
   ```

2. Compile all Java files:
   ```
   javac Product.java Inventory.java Main.java
   ```

3. Run the program:
   ```
   java Main
   ```

## Menu Options
- **Option 1**: Add a new product (enter ID, name, price, quantity)
- **Option 2**: Display all products in inventory
- **Option 3**: Update stock quantity of an existing product
- **Option 4**: Search for a product by its ID
- **Option 5**: View low stock alerts (products with quantity < 5)
- **Option 6**: Exit the program

## Project Structure
```
Inventory-and-Billing/
├── README.md
└── src/
    ├── Product.java      - Product class with fields and methods
    ├── Inventory.java    - Inventory management with all features
    └── Main.java         - Main class with menu and user input
```
