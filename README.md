# Automated Ordering System

A simple Java console application that simulates an automated ordering system. Users can create accounts, manage a product catalog, place orders, and calculate discounts. Orders can be delivered or picked up.

---

## Features

- User creation with input validation (first name, last name, email)  
- Product catalog creation with stock management  
- Place orders with quantity selection  
- Separate order list independent of stock  
- Discount system (10% for orders over 500 €, 20% for orders over 1000 €)  
- Delivery or pickup option  
- Repeatable orders  

---

## Getting Started

1. Clone the repository:  
```bash
git clone https://github.com/Dare2510/OrderService
```
2. Compile the code:
```bash
javac *.java
```
3. Run the application:
```bash
java OrderApp
```

Create User:
First Name: Max
Last Name: Mustermann
Email: max@example.com

Create Product Catalog:
Product: Laptop, Price: 1200, Stock: 5
Product: Mouse, Price: 20, Stock: 10

Place Order:
Product: Laptop, Quantity: 1
Product: Mouse, Quantity: 2

Final Price: 1216.0 €
Delivery or Pickup? (1) Delivery  (2) Pickup
