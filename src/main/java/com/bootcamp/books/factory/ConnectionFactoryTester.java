package com.bootcamp.books.factory;

import java.sql.Connection;

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
