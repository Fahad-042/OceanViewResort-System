package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/viewReservations")
public class ViewReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");

            request.setAttribute("reservations", rs);
            request.getRequestDispatcher("viewReservations.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}