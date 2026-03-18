package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection con;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:336/employeesdb",
                    "root",
                    "Santhu@123");

        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }
}