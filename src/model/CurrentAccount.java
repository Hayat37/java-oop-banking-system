package model;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    // Constructor
    public CurrentAccount(
            int accountNumber,
            double balance,
            double overdraftLimit
    ) {

        super(accountNumber, balance);

        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {

        if (amount <= getBalance() + overdraftLimit) {

            double newBalance = getBalance() - amount;

            setBalance(newBalance);

            System.out.println(amount + " withdrawn successfully.");

        } else {

            System.out.println("Overdraft limit exceeded.");
        }
    }
}