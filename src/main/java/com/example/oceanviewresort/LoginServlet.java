package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                response.sendRedirect("dashboard.jsp");

            } else {

                // 🔴 Set error message
                request.setAttribute("error", "Invalid username or password");

                // 🔴 Forward back to login page
                request.getRequestDispatcher("login.jsp")
                        .forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}