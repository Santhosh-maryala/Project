package com.example.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listBooks")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        BookDAO dao = new BookDAO();
        req.setAttribute("books", dao.getAllBooks());
        req.getRequestDispatcher("listBooks.jsp").forward(req, res);
    }
}