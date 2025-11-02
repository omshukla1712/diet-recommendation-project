package com.dietapp.server;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.dietapp.dao.UserDAO;
import com.dietapp.model.User;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        // --- Port: use environment variable PORT if present, otherwise default 8080
        port(getAssignedPort());

        // --- Serve static files from classpath /public
        staticFiles.location("/public");

        // --- Enable CORS for frontend fetch calls
        enableCORS();

        // --- Initialize DAO and Gson
        UserDAO userDAO = new UserDAO();
        Gson gson = new Gson();

        // --- Root redirect to index
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        // health
        get("/health", (req, res) -> {
            res.type("text/plain");
            return "Diet Recommendation API is running!";
        });

        // POST add user
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

        // GET users
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

    // Read PORT env var or return 8080
    private static int getAssignedPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException ignored) { }
        }
        return 8080;
    }

    // Enable very permissive CORS for development; OK for academic project.
    private static void enableCORS() {
        options("/*", (request, response) -> {
            String acrh = request.headers("Access-Control-Request-Headers");
            if (acrh != null) {
                response.header("Access-Control-Allow-Headers", acrh);
            }
            String acrm = request.headers("Access-Control-Request-Method");
            if (acrm != null) {
                response.header("Access-Control-Allow-Methods", acrm);
            }
            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });
    }
}
