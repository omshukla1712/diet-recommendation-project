package com.dietapp.util;
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/dietdb";
    private static final String USER = "dietuser";
    private static final String PASSWORD = "dietpass";
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
