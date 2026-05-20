package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {

            try {

                // Load MariaDB driver
                Class.forName("org.mariadb.jdbc.Driver");

                connection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/banking_system",
                        "bankuser",
                        "1234"
                );

                System.out.println("DB Connected ✅");

            } catch (ClassNotFoundException e) {

                System.out.println("Driver not found ❌");

            } catch (SQLException e) {

                System.out.println("DB Error: " + e.getMessage());
            }
        }

        return connection;
    }
}