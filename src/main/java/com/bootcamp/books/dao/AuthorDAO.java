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
}
