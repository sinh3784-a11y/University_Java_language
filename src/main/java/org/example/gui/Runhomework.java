package org.example.gui;
import java.util.Scanner;

public class Runhomework {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        for (int i=0 ; i<=3 ;i++) {
            System.out.println("1/. Show about StudentForm");
            System.out.println("2/. Show about EmployeeForm");
            System.out.println("3/. Exit");
            System.out.print("Choose your choice : ");
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
                    System.exit(0);
                }
                default: {
                    System.out.println("No thing.");
                }
            }
        }
    }

}
