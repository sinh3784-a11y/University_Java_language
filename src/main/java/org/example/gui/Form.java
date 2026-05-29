package org.example.gui;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.example.gui.*;
public class Form {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("1/. Show about StudentForm");
        System.out.println("2/. Show about EmployeeForm");
        System.out.println("3/. Exit");
        System.out.println("Choose your choice");
        int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    StudentForm studentForm = new StudentForm();
                    studentForm.setVisible(true);
                    break;
                }
                case 2: {
                    EmployeeForm employeeForm = new EmployeeForm();
                    employeeForm.setVisible(true);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("No thing.");
                }
            }
    }

}
