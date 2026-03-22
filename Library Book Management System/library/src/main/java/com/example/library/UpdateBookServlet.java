package com.example.library;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        Book b = new Book();
        b.setBook_id(Integer.parseInt(req.getParameter("id")));
        b.setTitle(req.getParameter("title"));
        b.setAuthor(req.getParameter("author"));
        b.setCategory(req.getParameter("category"));
        b.setQuantity(Integer.parseInt(req.getParameter("quantity")));

        new BookDAO().updateBook(b);
        res.sendRedirect("listBooks");
    }
}