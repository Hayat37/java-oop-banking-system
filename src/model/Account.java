package model;

public class Account {

    private int accountNumber;
    private double balance;

    // Constructor
    public Account(int accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter for balance
public double getBalance() {

    return balance;
}

// Getter for account number
public int getAccountNumber() {

    return accountNumber;
}

// Setter for balance
public void setBalance(double balance) {

    this.balance = balance;
}

    // Deposit method
    public void deposit(double amount) {

        balance = balance + amount;

        System.out.println(amount + " deposited successfully.");
    }

    // Withdraw method
    public void withdraw(double amount) {

        if (amount > balance) {

            System.out.println("Insufficient balance.");
        } else {

            balance = balance - amount;

            System.out.println(amount + " withdrawn successfully.");
        }
    }

    // Display account information
    public void displayAccountInfo() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}