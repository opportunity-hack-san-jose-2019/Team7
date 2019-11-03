package com.example.demo.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector {

    private static DatabaseConnector connector;

    private DatabaseConnector() {

    }

    public static DatabaseConnector getConnector() {
        if(connector == null) {
            connector = new DatabaseConnector();
        }
        return connector;
    }

    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
}
