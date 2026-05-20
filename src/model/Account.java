package model;
import exception.BankingException;

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
    // Deposit method
public void deposit(double amount) throws BankingException {

    if (amount <= 0) {

        throw new BankingException(
                "Deposit amount must be positive."
        );
    }

    balance = balance + amount;

    System.out.println(amount + " deposited successfully.");
}

    // Withdraw method
    // Withdraw method
public void withdraw(double amount)
        throws BankingException {

    if (amount <= 0) {

        throw new BankingException(
                "Withdraw amount must be positive."
        );
    }

    if (amount > balance) {

        throw new BankingException(
                "Insufficient balance."
        );
    }

    balance = balance - amount;

    System.out.println(amount + " withdrawn successfully.");
}

    // Display account information
    public void displayAccountInfo() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}