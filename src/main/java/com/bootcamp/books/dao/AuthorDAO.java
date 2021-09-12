package com.bootcamp.books.dao;

import com.bootcamp.books.model.author.Author;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {
    private final Connection connection;

    public AuthorDAO (Connection connection) {
        this.connection = connection;
    }

    public void insert (Author author) {
        try {
            String dml = "insert into authors (name, email, resume, birthday) values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(dml);
            statement.setString(1, author.getName());
            statement.setString(2, author.getEmail());
            statement.setString(3, author.getResume());
            statement.setDate(4, Date.valueOf(author.getBirthday()));
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
