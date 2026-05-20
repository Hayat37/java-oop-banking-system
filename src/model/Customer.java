package model;

import java.util.ArrayList;

public class Customer {

    private int customerId;
    private String name;
    private String address;
    private String phone;

    // List to store customer accounts
    private ArrayList<Account> accounts;

    // Constructor
    public Customer(int customerId, String name, String address, String phone) {

        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;

        // Create empty account list
        accounts = new ArrayList<>();
    }

    // Getter for customer ID
public int getCustomerId() {

    return customerId;
}

    // Add account
    public void addAccount(Account account) {

        accounts.add(account);

        System.out.println("Account added successfully.");
    }

    // Display customer information
    public void displayCustomerInfo() {

        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }


    // Display all customer accounts
    public void displayAccounts() {

        System.out.println("Accounts of " + name);

        for (Account account : accounts) {

            System.out.println("-------------------");

            account.displayAccountInfo();
        }
    }

    @Override
public String toString() {

    return customerId + ", " + name + ", " + address + ", " + phone;
}
}