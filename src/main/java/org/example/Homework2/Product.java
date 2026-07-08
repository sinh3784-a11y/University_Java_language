package org.example.Homework2;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private int key;
    private String name;
    private double price;
    private int quantity;

    public Product(int key, String name, double price, int quantity) {
        this.key = key;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Key: " + key
                + " | Name: " + name
                + " | Price: $" + price
                + " | Quantity: " + quantity;
    }
}
