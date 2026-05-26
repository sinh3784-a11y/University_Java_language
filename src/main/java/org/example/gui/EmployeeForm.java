package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeForm extends JFrame {
    JLabel lblTitle, lblSalary, lblTax, lblIncome;
    JTextField txtSalary, txtTax, txtIncome;
    JButton btnFind, btnClear, btnExit;

    public EmployeeForm() {
        // កំណត់ទម្រង់ Window រួម
        setTitle("Form Employee");
        setSize(450, 350);
        setLayout(null); // ប្រើប្រាស់ Ortonorme (Absolute Layout)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. បង្កើត Title
        lblTitle = new JLabel("Find Tax and Salay of Employee");
        lblTitle.setBounds(40, 20, 300, 25);

        // 2. បង្កើត Labels និង TextFields
        lblSalary = new JLabel("Input Salary not pay tax:");
        lblSalary.setBounds(40, 70, 160, 25);
        txtSalary = new JTextField();
        txtSalary.setBounds(200, 70, 120, 25);

        lblTax = new JLabel("Pay Tax:");
        lblTax.setBounds(40, 110, 160, 25);
        txtTax = new JTextField();
        txtTax.setBounds(200, 110, 120, 25);
        txtTax.setEditable(false); // សម្រាប់បង្ហាញលទ្ធផល

        lblIncome = new JLabel("Income of Employee:");
        lblIncome.setBounds(40, 150, 160, 25);
        txtIncome = new JTextField();
        txtIncome.setBounds(200, 150, 120, 25);
        txtIncome.setEditable(false); // សម្រាប់បង្ហាញលទ្ធផល

        // 3. បង្កើត ប៊ូតុង (Buttons)
        btnFind = new JButton("FIND");
        btnFind.setBounds(40, 210, 80, 30);

        btnClear = new JButton("Clear");
        btnClear.setBounds(140, 210, 80, 30);

        btnExit = new JButton("Exit");
        btnExit.setBounds(240, 210, 80, 30);

        // បញ្ចូល Components ទៅក្នុង Window
        add(lblTitle);
        add(lblSalary); add(txtSalary);
        add(lblTax); add(txtTax);
        add(lblIncome); add(txtIncome);
        add(btnFind); add(btnClear); add(btnExit);

        // --- ចាប់ផ្តើមសរសេរកូដដំណើរការ (Event Handling) ---

        // ប៊ូតុង FIND (ឧទាហរណ៍៖ អត្រាពន្ធរដ្ឋឧបមាថា 5% ឬតាមការកំណត់របស់អ្នក)
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double salary = Double.parseDouble(txtSalary.getText());
                    double taxRate = 0.05; // ឧបមាថាពន្ធ 5% (អ្នកអាចប្ដូរតាមរូបមន្តជាក់ស្ដែងបាន)

                    // បើផ្អែកលើរូបភាពគំរូ (Salary: 750, Tax: 31.4, Income: 718.6)
                    // វាប្រហាក់ប្រហែលនឹងអត្រាពន្ធ ~4.18%
                    double tax = salary * taxRate;
                    double income = salary - tax;

                    // បង្ហាញលទ្ធផល
                    txtTax.setText(String.format("%.1f", tax));
                    txtIncome.setText(String.format("%.1f", income));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "សូមបញ្ចូលចំនួនទឹកប្រាក់ខែជាលេខ!");
                }
            }
        });

        // ប៊ូតុង Clear
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSalary.setText("");
                txtTax.setText("");
                txtIncome.setText("");
            }
        });

        // ប៊ូតុង Exit
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeForm().setVisible(true);
        });
    }
}
