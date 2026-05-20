package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private Connection conn;

    public CustomerDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // CREATE
    public void addCustomer(Customer c) {

        try {

            String sql = "INSERT INTO customers VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, c.getCustomerId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getPhone());

            ps.executeUpdate();

            System.out.println("Customer saved to DB ✅");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ (simple fetch example)
    public void getAllCustomers() {

        try {

            String sql = "SELECT * FROM customers";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("customer_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("address") + " | " +
                        rs.getString("phone")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}