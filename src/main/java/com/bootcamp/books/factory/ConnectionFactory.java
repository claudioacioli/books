package com.bootcamp.books.factory;

import com.bootcamp.books.model.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** This return a connections to the database server
 *
 * @author claudio
 * create on 2021/09/12
 */
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
