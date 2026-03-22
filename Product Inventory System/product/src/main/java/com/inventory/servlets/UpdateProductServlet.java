package com.inventory.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.Product;
import com.inventory.dao.ProductDAO;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Product p = new Product();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setName(request.getParameter("product_name"));
            p.setPrice(Double.parseDouble(request.getParameter("price")));
            p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            p.setCategory(request.getParameter("category"));

            new ProductDAO().updateProduct(p);

            response.sendRedirect("viewProducts");

        } catch (IOException | NumberFormatException e) {
        }
    }
}