package model;

import java.util.ArrayList;

public class Bank {

    private String bankName;

    // List to store customers
    private ArrayList<Customer> customers;

    // Constructor
    public Bank(String bankName) {

        this.bankName = bankName;

        customers = new ArrayList<>();
    }

    // Add customer
    public void addCustomer(Customer customer) {

        customers.add(customer);

        System.out.println("Customer added successfully.");
    }

    // Display all customers
    public void displayAllCustomers() {

        System.out.println("Customers of " + bankName);

        for (Customer customer : customers) {

            System.out.println("-------------------");

            customer.displayCustomerInfo();
        }
    }

    // Search customer by ID
    public Customer searchCustomer(int customerId) {

        for (Customer customer : customers) {

            // Compare customer IDs
            if (customer.getCustomerId() == customerId) {

                return customer;
            }
        }

        return null;
    }
}