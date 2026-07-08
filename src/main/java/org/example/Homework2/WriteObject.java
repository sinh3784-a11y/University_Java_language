package org.example.Homework2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

// 1. WriteObject: Write 4 objects of class Product to Wobject.bin
// using FileOutputStream and ObjectOutputStream
public class WriteObject {
    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", 850.00, 10),
            new Product(2, "Mouse", 15.50, 100),
            new Product(3, "Keyboard", 25.75, 60),
            new Product(4, "Monitor", 199.99, 25)
        };

        try (FileOutputStream fos = new FileOutputStream("Wobject.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Product p : products) {
                oos.writeObject(p);
            }

            System.out.println("4 Product objects written to Wobject.bin successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
