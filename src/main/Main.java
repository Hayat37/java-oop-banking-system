package main;

import model.Bank;
import model.Customer;
import model.SavingsAccount;
import model.CurrentAccount;

import exception.BankingException;

import model.FileHandler;

import dao.CustomerDAO;
import dao.AccountDAO;

import gui.BankGUI;

public class Main {

    public static void main(String[] args) {

        // File handler
        FileHandler fileHandler = new FileHandler();

        // Create bank
        Bank bank = new Bank("Abyssinia Bank");

        // Create customer
        Customer customer1 = new Customer(
                2,
                "Hayat",
                "Addis Ababa",
                "0911223344"
        );

        // Save customer to file
        fileHandler.saveToFile(
                "Customer: " + customer1,
                "bank-data.txt"
        );

        // Save customer to database
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.addCustomer(customer1);

        System.out.println("\n===== CUSTOMERS =====");
        customerDAO.getAllCustomers();

        // Create accounts
        SavingsAccount savings1 =
                new SavingsAccount(1001, 10000, 10);

        CurrentAccount current1 =
                new CurrentAccount(2001, 5000, 3000);

        // Save accounts to file
        fileHandler.saveToFile(
                "Account: " + savings1,
                "bank-data.txt"
        );

        fileHandler.saveToFile(
                "Account: " + current1,
                "bank-data.txt"
        );

        // Add accounts to customer
        customer1.addAccount(savings1);
        customer1.addAccount(current1);

        // Add customer to bank
        bank.addCustomer(customer1);

        // Database account operations
        AccountDAO accDAO = new AccountDAO();

        // Save accounts to DB FIRST
        accDAO.addAccount(1001, 10000, 10, 2);

        accDAO.addAccount(2001, 5000, 0, 2);

        System.out.println("\n===== ACCOUNTS =====");
        accDAO.getAllAccounts();

        System.out.println("\n===== TRANSACTIONS =====");

        // Deposit
        accDAO.deposit(1001, 2000);

        // Withdraw
        accDAO.withdraw(1001, 1000);

        // Transfer
        accDAO.transfer(1001, 2001, 500);

        System.out.println("\n===== UPDATED ACCOUNTS =====");
        accDAO.getAllAccounts();

        // OOP testing
        System.out.println("\n===== OOP TEST =====");

        try {

            // Valid deposit
            savings1.deposit(2000);

            // Invalid withdraw
            savings1.withdraw(50000);

        } catch (BankingException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        System.out.println("-------------------");

        savings1.displayAccountInfo();

        // Launch GUI
        BankGUI gui = new BankGUI();

        gui.setVisible(true);
    }
}