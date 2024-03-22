package com.example.billdesk2;

public class BillModel {
    static String name;        // Name of the product
    String quantity;    // Quantity of the product
    static int price;          // Price of the product
    int totalPrice;     // Total price for the quantity

    public BillModel(String name, String quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = price; // Calculate total price
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
        this.totalPrice =  price; // Recalculate total price when quantity changes
    }

    public static int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        this.totalPrice =  price; // Recalculate total price when price changes
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
