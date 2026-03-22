package com.inventory.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.Product;
import com.inventory.dao.ProductDAO;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product p = new ProductDAO().getProductById(id);
        request.setAttribute("product", p);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }
}