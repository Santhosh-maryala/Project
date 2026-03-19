package com.example.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        System.out.println(name + " " + email + " " + course);

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO students(name,email,course) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Insert Successful");
            } else {
                System.out.println("Insert Failed");
            }

            response.sendRedirect("viewStudents.jsp");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}