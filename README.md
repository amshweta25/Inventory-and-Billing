# Team F - Inventory and Billing System

Java project for inventory control and billing counter.

## Features Included
1. Stock management (Add new products, update quantity, show all items)
2. Low-stock alerts (Checks if item count is less than 5)
3. Invoice generation (Customer billing with price calculation and automatic stock reduction)
4. Sales reports (List of past bills and total money made)

## Project Requirements
- **OOP Concepts**:
  - Abstraction: `Item` is an abstract class with `printDetails()`.
  - Inheritance: `Product` extends `Item`.
  - Encapsulation: Private variables accessed using getters/setters.
  - Polymorphism: `@Override` on `printDetails()` method.
- **Custom Exceptions**:
  - `ProductNotFoundException` (if product id is wrong)
  - `NotEnoughStockException` (if customer tries to buy more than we have)
- **DSA Implementation**:
  - Bubble sort to arrange products by ID.
  - Binary search to search product by ID.
- **Collections Framework**:
  - `ArrayList` for storing products and bill records.
  - `HashMap` for fast ID to product lookup.

## How to Compile and Run
```bash
cd src
javac Item.java Product.java ProductNotFoundException.java NotEnoughStockException.java Inventory.java Main.java
java Main
```
