package main;

import model.Bank;
import model.Customer;
import model.SavingsAccount;
import model.CurrentAccount;

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

        // Create current account
        CurrentAccount current1 = new CurrentAccount(
                2001,
                5000,
                3000
        );

        // Add accounts to customer
        customer1.addAccount(savings1);
        customer1.addAccount(current1);

        // Add customer to bank
        bank.addCustomer(customer1);

        System.out.println("-------------------");

        // Savings account test
        savings1.displayAccountInfo();

        savings1.applyInterest();

        savings1.displayAccountInfo();

        System.out.println("-------------------");

        // Current account test
        current1.displayAccountInfo();

        System.out.println("-------------------");

        // Withdraw using overdraft
        current1.withdraw(7000);

        System.out.println("-------------------");

        current1.displayAccountInfo();
    }
}