package com.bootcamp.books.dao;

import com.bootcamp.books.model.author.Author;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<Author> getAll () {
        try {
            List<Author> authors = new LinkedList<>();
            String sql = "select name, email, resume, birthday from authors";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
                authors.add(new Author(
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("resume"),
                    resultSet.getDate("birthday").toLocalDate()
                ));

            resultSet.close();
            statement.close();

            return authors;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
