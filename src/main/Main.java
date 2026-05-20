package main;

import model.Bank;
import model.Customer;
import model.SavingsAccount;
import model.CurrentAccount;

import exception.BankingException;
import model.FileHandler;

public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();

        // Create bank
        Bank bank = new Bank("Abyssinia Bank");

        // Create customer
        Customer customer1 = new Customer(
                1,
                "Hayat",
                "Addis Ababa",
                "0911223344"
        );
        fileHandler.saveToFile(
        "Customer: " + customer1,
        "bank-data.txt"
);

        // Create accounts
        SavingsAccount savings1 =
                new SavingsAccount(1001, 10000, 10);

        CurrentAccount current1 =
                new CurrentAccount(2001, 5000, 3000);
  fileHandler.saveToFile(
        "Account: " + savings1,
        "bank-data.txt"
);
        // Add accounts
        customer1.addAccount(savings1);
        customer1.addAccount(current1);

        bank.addCustomer(customer1);

        System.out.println("-------------------");

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
    }
}