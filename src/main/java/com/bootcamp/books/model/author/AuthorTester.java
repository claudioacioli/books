package com.bootcamp.books.model.author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthorTester {
    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setName("Cal Newport");
        author1.setEmail("calnewport@gmail.com");
        author1.setBirthday(LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        author1.setResume(
                author1.getName() + "(born " + author1.getBirthday().format(DateTimeFormatter.ofPattern("yyyy")) + ")" +
                " is an American non-fiction author and associate professor " +
                        "of computer science at Georgetown University.");

        System.out.println(author1);
    }
}
