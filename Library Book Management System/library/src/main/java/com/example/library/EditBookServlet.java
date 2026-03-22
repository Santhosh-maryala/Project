package com.example.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        BookDAO dao = new BookDAO();
        Book book = dao.getBookById(id);

        req.setAttribute("book", book);
        req.getRequestDispatcher("editBook.jsp").forward(req, res);
    }
}