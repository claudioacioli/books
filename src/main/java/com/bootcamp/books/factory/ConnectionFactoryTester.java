package com.bootcamp.books.factory;

import java.sql.Connection;

/** This test driver try a simple connection with the database server
 *
 * @author claudio
 * create on 2021/09/12
 * @see ConnectionFactory
 */
public class ConnectionFactoryTester {
    public static void main(String[] args) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            System.out.println("connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
