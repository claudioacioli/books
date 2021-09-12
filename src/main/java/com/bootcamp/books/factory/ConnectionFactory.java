package com.bootcamp.books.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection () {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(getUri());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String getUri () {
        int port = 3306;
        String host = "10.0.3.156";
        String user = "books";
        String password = "books";
        String database = "books";

        return String.format(
                "jdbc:mariadb://%s:%d/%s?user=%s&password=%s",
                host,
                port,
                database,
                user,
                password
        );
    }
}
