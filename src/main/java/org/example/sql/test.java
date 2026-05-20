package org.example.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class test {
    public static void main(String[] args) {
        // ចំណុចសំខាន់៖ school_db គឺត្រូវដូចឈ្មោះ Database ក្នុង Workbench
        String url = "jdbc:mysql://localhost:3306/java-test-database?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root"; // ឈ្មោះ User របស់ MySQL ភាគច្រើនគឺ root
        String password = "sinhna15042024";     // ដាក់ Password MySQL របស់អ្នក (បើអត់មានទេ ទុកទទេ "")

        try {
            // ១. បង្កើតការភ្ជាប់ (Connection)
            Connection connection = DriverManager.getConnection(url, username, password);

            // ២. បង្កើត Statement ដើម្បីសរសេរ Command ទៅកាន់ MySQL
            Statement statement = connection.createStatement();

            // ៣. រត់កូដ SQL Select ទាញទិន្នន័យ
            String sql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sql);

            // ៤. ប្រើ Loop ដើម្បីបង្ហាញលទ្ធផលដែលទាញបាន
            System.out.println("--- បញ្ជីឈ្មោះសិស្សពី MySQL ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + " | ឈ្មោះ: " + name + " | អ៊ីមែល: " + email);
            }

            // បិទការភ្ជាប់ក្រោយប្រើរួច
            connection.close();

        } catch (Exception e) {
            System.out.println("មានបញ្ហាពេលភ្ជាប់ទៅកាន់ Database!");
            e.printStackTrace();
        }
    }
}