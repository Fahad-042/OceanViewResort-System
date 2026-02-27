package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/deleteReservation")
public class DeleteReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM reservation WHERE reservation_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}