package model;

public class SavingsAccount extends Account {

    private double interestRate;

    // Constructor
    public SavingsAccount(
            int accountNumber,
            double balance,
            double interestRate
    ) {

        // Call parent constructor
        super(accountNumber, balance);

        this.interestRate = interestRate;
    }

    // Method to apply interest
    public void applyInterest() {

    double interest = getBalance() * interestRate / 100;

    try {

        deposit(interest);

        System.out.println("Interest applied: " + interest);

    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}

}