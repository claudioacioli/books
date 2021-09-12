package com.bootcamp.books.dao;

import com.bootcamp.books.factory.ConnectionFactory;

public class QueryAuthorDAOTester {
    public static void main(String[] args) {
        new AuthorDAO(new ConnectionFactory().getConnection())
                .getAll()
                .forEach(System.out::println);
    }
}
