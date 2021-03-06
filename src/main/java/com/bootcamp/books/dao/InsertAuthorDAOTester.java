package com.bootcamp.books.dao;

import com.bootcamp.books.factory.ConnectionFactory;
import com.bootcamp.books.model.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This test driver try insert an author on database
 *
 * @author claudio
 * create on 2021/09/12
 * @see Author
 * @see ConnectionFactory
 * @see AuthorDAO
 */
public class InsertAuthorDAOTester {
    public static void main(String[] args) {
        try {
            Author author = new Author(
                    "Dale Carnegie",
                    "dale_carnegie@gmail.com",
                    "Dale Carnegie (born 1988) " +
                            "was an American writer and lecturer, " +
                            "and the developer of courses in self-improvement, " +
                            "salesmanship, corporate training, public speaking, and interpersonal skills.",
                    LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
            );

            AuthorDAO dao = new AuthorDAO(new ConnectionFactory().getConnection());
            dao.insert(author);
            System.out.println("inserted");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
