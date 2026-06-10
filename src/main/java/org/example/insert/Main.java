package org.example.insert;
import java.sql.*;
import java.util.Scanner;

public class Main  {

    static Scanner sc = new Scanner(System.in);

    // INSERT
    public static void insertStudent() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Major: ");
        String major = sc.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble();

        String sql =
                "INSERT INTO students(name,age,major,gpa) VALUES(?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, major);
            ps.setDouble(4, gpa);

            ps.executeUpdate();

            System.out.println("Insert Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void displayStudents() {

        String sql = "SELECT * FROM students";

        try (
                Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            System.out.println("\n===== STUDENT LIST =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("major") + " | " +
                        rs.getDouble("gpa")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateStudent() {

        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Age: ");
        int age = sc.nextInt();

        sc.nextLine();
        System.out.print("New Major: ");
        String major = sc.nextLine();
        
        System.out.print("New GPA: ");
        double gpa = sc.nextDouble();

        String sql =
                "UPDATE students SET name=?, age=?, major=?, gpa=? WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, major);
            ps.setDouble(4, gpa);
            ps.setInt(5, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Update Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteStudent() {

        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();

        String sql =
                "DELETE FROM students WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Delete Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH
    public static void searchStudent() {

        sc.nextLine();

        System.out.print("Enter Name: ");
        String keyword = sc.nextLine();

        String sql =
                "SELECT * FROM students WHERE name LIKE ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== SEARCH RESULT =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("major") + " | " +
                        rs.getDouble("gpa")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MAIN
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Display");
            System.out.println("2. Insert");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayStudents();
                    break;

                case 2:
                    insertStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    System.out.println("Program Ended!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}