package com.bootcamp.books.servlet;

import com.bootcamp.books.dao.AuthorDAO;
import com.bootcamp.books.factory.ConnectionFactory;
import com.bootcamp.books.model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/** This creates and show  all authors from the database.
 *
 * @author claudio
 * create on 2021/09/12
 * @see Author
 * @see ConnectionFactory
 * @see AuthorDAO
 */
@WebServlet("/")
public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDAO dao = new AuthorDAO(new ConnectionFactory().getConnection());
        List<Author> authors = dao.getAll();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/WEB-INF/views/author.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = getAuthorFromForm(req);

        AuthorDAO dao = new AuthorDAO(new ConnectionFactory().getConnection());
        dao.insert(author);

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
