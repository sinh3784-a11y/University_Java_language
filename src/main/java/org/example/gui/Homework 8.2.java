package org.example.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EmployeeForm extends JFrame {
    JLabel lblTitle, lblId, lblName, lblSex, lblPosition, lblSalary, lblTax, lblIncome;
    JTextField txtId, txtName, txtSex, txtPosition, txtSalary, txtTax, txtIncome;
    JButton btnFind, btnSave, btnClear, btnExit;

    public EmployeeForm() {
        // កំណត់ទម្រង់ Window រួម
        setTitle("Form Employee of the company");
        setSize(450, 480);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // 1. បង្កើត Title
        lblTitle = new JLabel("Find Tax and Salary of Employee");
        lblTitle.setBounds(130, 20, 400, 25);
        //id
        lblId = new JLabel("Input employee Id:");
        lblId.setBounds(40, 70, 160, 25);
        txtId = new JTextField();
        txtId.setBounds(200, 70, 120, 25);
        //name
        lblName = new JLabel("Input employee Name:");
        lblName.setBounds(40, 110, 160, 25);
        txtName = new JTextField();
        txtName.setBounds(200, 110, 120, 25);
        //sex
        lblSex = new JLabel("Input employee Sex:");
        lblSex.setBounds(40, 150, 160, 25);
        txtSex = new JTextField();
        txtSex.setBounds(200, 150, 120, 25);
        //position
        lblPosition = new JLabel("Input employee Position:");
        lblPosition.setBounds(40, 190, 160, 25);
        txtPosition = new JTextField();
        txtPosition.setBounds(200, 190, 120, 25);
        //salary
        lblSalary = new JLabel("Input Salary not pay tax:");
        lblSalary.setBounds(40, 230, 160, 25);
        txtSalary = new JTextField();
        txtSalary.setBounds(200, 230, 120, 25);
        //tax
        lblTax = new JLabel("Pay Tax:");
        lblTax.setBounds(40, 270, 160, 25);
        txtTax = new JTextField();
        txtTax.setBounds(200, 270, 120, 25);
        txtTax.setEditable(false); // សម្រាប់បង្ហាញលទ្ធផល
        //income
        lblIncome = new JLabel("Income of Employee:");
        lblIncome.setBounds(40, 310, 160, 25);
        txtIncome = new JTextField();
        txtIncome.setBounds(200, 310, 120, 25);
        txtIncome.setEditable(false); // សម្រាប់បង្ហាញលទ្ធផល

        // 3. បង្កើត ប៊ូតុង (Buttons)
        btnFind = new JButton("FIND");
        btnFind.setBounds(30, 370, 80, 30);

        btnSave = new JButton("SAVE");
        btnSave.setBounds(130, 370, 80, 30);

        btnClear = new JButton("CLEAR");
        btnClear.setBounds(230, 370, 80, 30);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(330, 370, 80, 30);

        // បញ្ចូល Components ទៅក្នុង Window
        add(lblTitle);
        add(lblId); add(txtId);
        add(lblName); add(txtName);
        add(lblSex); add(txtSex);
        add(lblPosition); add(txtPosition);
        add(lblSalary); add(txtSalary);
        add(lblTax); add(txtTax);
        add(lblIncome); add(txtIncome);
        add(btnFind); add(btnSave); add(btnClear); add(btnExit);

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double salary = Double.parseDouble(txtSalary.getText());
                    double taxRate;
                    if(salary >= 250) {
                        taxRate = 0.05;
                    }
                    else {
                        taxRate = 0.10;
                    }
                    double tax = salary * taxRate;
                    double income = salary - tax;

                    // បង្ហាញលទ្ធផល
                    txtTax.setText(String.format("%.2f", tax));
                    txtIncome.setText(String.format("%.2f", income));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "សូមបញ្ចូលចំនួនទឹកប្រាក់ខែជាលេខ!");
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        // ប៊ូតុង Clear
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtSex.setText("");
                txtPosition.setText("");
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
