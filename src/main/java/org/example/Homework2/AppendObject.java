package org.example.Homework2;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.File;
// 3. AppendObject: Append objects of class Product to Aobject.bin
// using FileOutputStream, BufferedOutputStream, ObjectOutputStream.
public class AppendObject {
    public static void main(String[] args) {

        Product[] newProducts = {
            new Product(5, "Printer", 120.00, 8),
            new Product(6, "Webcam", 45.25, 30)
        };

        File file = new File("Aobject.bin");
        boolean fileExists = file.exists() && file.length() > 0;

        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            ObjectOutputStream oos;
            if (fileExists) {
                // Avoid writing a new stream header when appending
                oos = new AppendableObjectOutputStream(bos);
            } else {
                oos = new ObjectOutputStream(bos);
            }

            for (Product p : newProducts) {
                oos.writeObject(p);
            }
            oos.flush();

            System.out.println("Product objects appended to Aobject.bin successfully.");

        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
