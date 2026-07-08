package org.example.Homework2;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;

// 4. ShowObject: Read all objects from Aobject.bin and output on screen
// using FileInputStream, BufferedInputStream, ObjectInputStream.
public class ShowObject {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("Aobject.bin");
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            System.out.println("---- Products in Aobject.bin ----");
            while (true) {
                Product p = (Product) ois.readObject();
                System.out.println(p);
            }

        } catch (EOFException eof) {
            // Normal end of file, do nothing
            System.out.println("\nEnd of file reached. All objects displayed.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
