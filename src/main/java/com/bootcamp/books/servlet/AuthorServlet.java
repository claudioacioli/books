package com.bootcamp.books.servlet;

import com.bootcamp.books.model.author.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/")
public class AuthorServlet extends HttpServlet {

    private final List<Author> authors = new LinkedList<>();

    public AuthorServlet () {
        authors.add(new Author(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                "Dale Carnegie (born 1988) " +
                        "was an American writer and lecturer, " +
                        "and the developer of courses in self-improvement, " +
                        "salesmanship, corporate training, public speaking, and interpersonal skills.",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        ));
        authors.add(new Author(
                "Cal Newport",
                "calnewport@gmail.com",
               "Cal Newport (born 1982) " +
                        "is an American non-fiction author and associate professor " +
                        "of computer science at Georgetown University.",
                LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        ));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/WEB-INF/views/author.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = getAuthorFromForm(req);
        authors.add(author);
        resp.sendRedirect(req.getContextPath() + '/');
    }

    private Author getAuthorFromForm (HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate birthday = LocalDate.parse(
                req.getParameter("birthday"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        );
        String resume = req.getParameter("resume");

        return new Author(name, email, resume, birthday);
    }
}
