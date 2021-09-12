package com.bootcamp.books.dao;

import com.bootcamp.books.factory.ConnectionFactory;
import com.bootcamp.books.model.Author;

/** This test driver show all authors from the database
 *
 * @author claudio
 * create on 2021/09/12
 * @see Author
 * @see ConnectionFactory
 * @see AuthorDAO
 */
public class QueryAuthorDAOTester {
    public static void main(String[] args) {
        new AuthorDAO(new ConnectionFactory().getConnection())
                .getAll()
                .forEach(System.out::println);
    }
}
