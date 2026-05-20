package gui;

import dao.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame {

    private JTextField accountField;
    private JTextField amountField;

    private JButton depositButton;
    private JButton withdrawButton;

    private JTextArea outputArea;

    private AccountDAO accountDAO;

    public BankGUI() {

        accountDAO = new AccountDAO();

        setTitle("Banking System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Labels
        panel.add(new JLabel("Account Number:"));
        accountField = new JTextField();
        panel.add(accountField);

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        // Buttons
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        panel.add(depositButton);
        panel.add(withdrawButton);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Deposit event
        depositButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int accountNumber =
                        Integer.parseInt(accountField.getText());

                double amount =
                        Double.parseDouble(amountField.getText());

                accountDAO.deposit(accountNumber, amount);

                outputArea.append(
                        amount + " deposited to account "
                                + accountNumber + "\n"
                );
            }
        });

        // Withdraw event
        withdrawButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int accountNumber =
                        Integer.parseInt(accountField.getText());

                double amount =
                        Double.parseDouble(amountField.getText());

                accountDAO.withdraw(accountNumber, amount);

                outputArea.append(
                        amount + " withdrawn from account "
                                + accountNumber + "\n"
                );
            }
        });
    }
}