package org.example.gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    // ប្រកាស Components
    JLabel lblTitle, lblCode, lblMidterm, lblFinal, lblTotal, lblUpdate, lblResult;
    JTextField txtCode, txtMidterm, txtFinal, txtTotal, txtUpdate, txtResult;
    JButton btnAdd, btnFind, btnClear, btnOutput, btnExit;

    public StudentForm() {
        // កំណត់ទម្រង់ Window រួម
        setTitle("Programming Java with GUI: AWT or Swing");
        setSize(550, 500);
        setLayout(null); // ប្រើប្រាស់ Ortonorme (Absolute Layout)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. បង្កើត Title និង Labels
        lblTitle = new JLabel("Input Information of Student(Id, Midterm and Final)");
        lblTitle.setBounds(50, 20, 450, 25);
        JLabel lblSubTitle = new JLabel("And then Update 15% to your score < 50");
        lblSubTitle.setBounds(100, 40, 300, 20);

        lblCode = new JLabel("Enter Code:");
        lblCode.setBounds(50, 80, 100, 25);
        lblMidterm = new JLabel("Enter Midterm:");
        lblMidterm.setBounds(50, 110, 100, 25);
        lblFinal = new JLabel("Enter Final:");
        lblFinal.setBounds(50, 140, 100, 25);

        // 2. បង្កើត TextFields សម្រាប់បញ្ចូលទិន្នន័យ
        txtCode = new JTextField();
        txtCode.setBounds(180, 80, 150, 25);
        txtMidterm = new JTextField();
        txtMidterm.setBounds(180, 110, 150, 25);
        txtFinal = new JTextField();
        txtFinal.setBounds(180, 140, 150, 25);

        // 3. បង្កើត Buttons ជួរទីមួយ
        btnAdd = new JButton("Add");
        btnAdd.setBounds(50, 180, 80, 30);
        btnFind = new JButton("FIND");
        btnFind.setBounds(140, 180, 80, 30);
        btnClear = new JButton("Clear");
        btnClear.setBounds(230, 180, 80, 30);

        // 4. បង្កើត Labels និង TextFields សម្រាប់បង្ហាញលទ្ធផល (បៃតង)
        lblTotal = new JLabel("Total Score :");
        lblTotal.setBounds(50, 240, 120, 25);
        lblUpdate = new JLabel("Update Score :");
        lblUpdate.setBounds(50, 270, 120, 25);
        lblResult = new JLabel("Result Score :");
        lblResult.setBounds(50, 300, 120, 25);

        txtTotal = new JTextField();
        txtTotal.setBounds(180, 240, 150, 25);
        txtTotal.setEditable(false);

        txtUpdate = new JTextField();
        txtUpdate.setBounds(180, 270, 150, 25);
        txtUpdate.setEditable(false);

        txtResult = new JTextField();
        txtResult.setBounds(180, 300, 150, 25);
        txtResult.setEditable(false);

        // 5. បង្កើត Buttons ជួរក្រោម
        btnOutput = new JButton("Output");
        btnOutput.setBounds(80, 350, 100, 30);
        btnExit = new JButton("Exit");
        btnExit.setBounds(220, 350, 100, 30);

        // បញ្ចូល Components ទាំងអស់ទៅក្នុង Window
        add(lblTitle); add(lblSubTitle);
        add(lblCode); add(lblMidterm); add(lblFinal);
        add(txtCode); add(txtMidterm); add(txtFinal);
        add(btnAdd); add(btnFind); add(btnClear);
        add(lblTotal); add(lblUpdate); add(lblResult);
        add(txtTotal); add(txtUpdate); add(txtResult);
        add(btnOutput); add(btnExit);

        // --- ចាប់ផ្តើមសរសេរកូដដំណើរការ (Event Handling) ---

        // ប៊ូតុង Add ឬ Output សម្រាប់គណនាពិន្ទុ
        ActionListener calculateAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double midterm = Double.parseDouble(txtMidterm.getText());
                    double midtermFinal = Double.parseDouble(txtFinal.getText());

                    double total = midterm + midtermFinal;
                    double update = 0;

                    if (total < 50) {
                        update = total * 0.15; // ថែមលុយ/ពិន្ទុ 15%
                    }

                    double result = total + update;

                    // បង្ហាញនៅលើប្រអប់លទ្ធផល
                    txtTotal.setText(String.format("%.2f", total));
                    txtUpdate.setText(String.format("%.2f", update));
                    txtResult.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "សូមបញ្ចូលលេខឱ្យបានត្រឹមត្រូវ!");
                }
            }
        };
        btnAdd.addActionListener(calculateAction);
        btnOutput.addActionListener(calculateAction);

        // ប៊ូតុង Clear
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCode.setText("");
                txtMidterm.setText("");
                txtFinal.setText("");
                txtTotal.setText("");
                txtUpdate.setText("");
                txtResult.setText("");
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
            new StudentForm().setVisible(true);
        });
    }
}
