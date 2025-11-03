package com.dietapp.server;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.dietapp.dao.UserDAO;
import com.dietapp.model.User;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        port(getAssignedPort());
        staticFiles.location("/public");
        enableCORS("*", "GET,POST,PUT,DELETE,OPTIONS", "Content-Type,Authorization,X-Requested-With");
        UserDAO userDAO = new UserDAO();
        Gson gson = new Gson();
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        get("/health", (req, res) -> {
            res.type("text/plain");
            return "Diet Recommendation API is running!";
        });
        post("/addUser", (req, res) -> {
            res.type("application/json");
            try {
                User user = gson.fromJson(req.body(), User.class);
                boolean success = userDAO.saveUser(user);
                if (success) {
                    res.status(200);
                    return "{\"message\":\"User added successfully!\"}";
                } else {
                    res.status(500);
                    return "{\"error\":\"Error adding user.\"}";
                }
            } catch (Exception e) {
                e.printStackTrace();
                res.status(400);
                return "{\"error\":\"Invalid request format.\"}";
            }
        });

        get("/users", (req, res) -> {
            res.type("application/json");
            try {
                List<User> users = userDAO.getAllUsers();
                return gson.toJson(users);
            } catch (Exception e) {
                e.printStackTrace();
                res.status(500);
                return "{\"error\":\"Error fetching users.\"}";
            }
        });
    }

    private static int getAssignedPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException ignored) { }
        }
        return 8080;
    }

}
