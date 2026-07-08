package org.example.Homework2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 2. ReadObject: Read all objects from Wobject.bin and output on screen
// using FileInputStream and ObjectInputStream.
// Also allows the User to add new Product(s) and append them,
// automatically generating the next key number.
public class ReadObject {
    public static void main(String[] args) {

        ArrayList<Product> productList = new ArrayList<>();
        int maxKey = 0;

        // ---- Read all existing objects from Wobject.bin ----
        try (FileInputStream fis = new FileInputStream("Wobject.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            System.out.println("---- Products in Wobject.bin ----");
            while (true) {
                Product p = (Product) ois.readObject();
                productList.add(p);
                if (p.getKey() > maxKey) {
                    maxKey = p.getKey();
                }
                System.out.println(p);
            }

        } catch (EOFException eof) {
            // Normal end of file, do nothing
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // ---- Allow user to add new products ----
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> newProducts = new ArrayList<>();

        System.out.print("\nDo you want to add new product(s)? (y/n): ");
        String choice = sc.nextLine().trim();

        while (choice.equalsIgnoreCase("y")) {
            maxKey++; // auto-generate next key

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter product price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("Enter product quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            Product newP = new Product(maxKey, name, price, qty);
            newProducts.add(newP);
            productList.add(newP);

            System.out.println("Added -> " + newP);

            System.out.print("Add another product? (y/n): ");
            choice = sc.nextLine().trim();
        }

        // ---- Append newly entered products back to Wobject.bin ----
        if (!newProducts.isEmpty()) {
            try (FileOutputStream fos = new FileOutputStream("Wobject.bin", true);
                 ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {

                for (Product p : newProducts) {
                    oos.writeObject(p);
                }
                System.out.println("\n" + newProducts.size() + " new product(s) saved to Wobject.bin.");

            } catch (IOException e) {
                System.out.println("Error appending to file: " + e.getMessage());
            }
        }

        // ---- Final list ----
        System.out.println("\n---- Final Product List ----");
        for (Product p : productList) {
            System.out.println(p);
        }

        sc.close();
    }
}
