package com.dietapp.dao;

import com.dietapp.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/dietdb";
    private static final String USER = "dietuser";     // <-- change if table owned by dietuser
    private static final String PASSWORD = "dietpass"; // <-- must match that user's password

    public boolean saveUser(User user) {
        String sql = "INSERT INTO users (name, age, height, weight, gender, activity_level, goal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("Using DB URL: " + URL + " | DB_USER: " + USER);
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setDouble(3, user.getHeight());
            stmt.setDouble(4, user.getWeight());
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getActivityLevel());
            stmt.setString(7, user.getGoal());

            int rows = stmt.executeUpdate();
            System.out.println("Inserted rows: " + rows);
            return true;
        } catch (SQLException e) {
            System.err.println("SQL Error while inserting user:");
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
            return false;
        }
    }

    // Return list of users (used by GET /users)
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, name, age, height, weight, gender, activity_level, goal FROM users";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User u = new User();
                // assuming your User class has setters
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));
                u.setHeight((float) rs.getDouble("height"));
                u.setWeight((float) rs.getDouble("weight"));
                u.setGender(rs.getString("gender"));
                u.setActivityLevel(rs.getString("activity_level"));
                u.setGoal(rs.getString("goal"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
