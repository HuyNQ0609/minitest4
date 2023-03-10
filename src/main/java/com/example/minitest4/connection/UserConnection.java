package com.example.minitest4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnection {
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;

    {
        jdbcURL = "jdbc:mysql://localhost:3306/user_manager?useSSL=false";
        jdbcUsername = "root";
        jdbcPassword = "Huynhitu12";
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
