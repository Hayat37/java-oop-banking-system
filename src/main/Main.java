package main;

import model.Bank;
import model.Customer;
import model.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        // Create bank
        Bank bank = new Bank("Abyssinia Bank");

        // Create customer
        Customer customer1 = new Customer(
                1,
                "Hayat",
                "Addis Ababa",
                "0911223344"
        );

        // Create savings account
        SavingsAccount savings1 = new SavingsAccount(
                1001,
                10000,
                10
        );

        // Add account to customer
        customer1.addAccount(savings1);

        // Add customer to bank
        bank.addCustomer(customer1);

        System.out.println("-------------------");

        // Display before interest
        savings1.displayAccountInfo();

        System.out.println("-------------------");

        // Apply interest
        savings1.applyInterest();

        System.out.println("-------------------");

        // Display after interest
        savings1.displayAccountInfo();
    }
}