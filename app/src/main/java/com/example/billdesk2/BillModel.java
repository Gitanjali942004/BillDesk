package com.example.billdesk2;

public class BillModel {
    String name;        // Name of the product
    String quantity;    // Quantity of the product
    int price;          // Price of the product
    int totalPrice;     // Total price for the quantity

    public BillModel(String name, String quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = price; // Calculate total price
    }




    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
