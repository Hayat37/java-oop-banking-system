package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    private Connection conn;

    public AccountDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // CREATE account
    public void addAccount(int accNo, double balance, double rate, int customerId) {

        try {

            String sql = "INSERT INTO accounts VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accNo);
            ps.setDouble(2, balance);
            ps.setDouble(3, rate);
            ps.setInt(4, customerId);

            ps.executeUpdate();

            System.out.println("Account saved to DB ✅");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deposit(int accountNumber, double amount) {

    try {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, amount);
        ps.setInt(2, accountNumber);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println(amount + " deposited successfully 💰");
        } else {
            System.out.println("Account not found ❌");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public void withdraw(int accountNumber, double amount) {

    try {

        // Step 1: check balance
        String checkSql = "SELECT balance FROM accounts WHERE account_number = ?";

        PreparedStatement checkPs = conn.prepareStatement(checkSql);
        checkPs.setInt(1, accountNumber);

        ResultSet rs = checkPs.executeQuery();

        if (rs.next()) {

            double balance = rs.getDouble("balance");

            if (balance >= amount) {

                String sql = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setDouble(1, amount);
                ps.setInt(2, accountNumber);

                ps.executeUpdate();

                System.out.println(amount + " withdrawn successfully 💸");

            } else {

                System.out.println("Error: Insufficient balance ❌");
            }

        } else {
            System.out.println("Account not found ❌");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public void transfer(int fromAcc, int toAcc, double amount) {

    try {

        conn.setAutoCommit(false); // start transaction

        // Withdraw from sender
        withdraw(fromAcc, amount);

        // Deposit to receiver
        deposit(toAcc, amount);

        conn.commit();

        System.out.println("Transfer successful 🔁");

    } catch (Exception e) {

        try {
            conn.rollback();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Transfer failed ❌");
    }
}

    // READ account
    public void getAllAccounts() {

        try {

            String sql = "SELECT * FROM accounts";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("account_number") + " | " +
                        rs.getDouble("balance") + " | " +
                        rs.getDouble("interest_rate") + " | " +
                        rs.getInt("customer_id")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}