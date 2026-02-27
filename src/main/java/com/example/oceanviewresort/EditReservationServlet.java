package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/editReservation")
public class EditReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM reservation WHERE reservation_id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("id", rs.getInt("reservation_id"));
                request.setAttribute("guest_name", rs.getString("guest_name"));
                request.setAttribute("address", rs.getString("address"));
                request.setAttribute("contact_number", rs.getString("contact_number"));
                request.setAttribute("room_type", rs.getString("room_type"));
                request.setAttribute("check_in_date", rs.getDate("check_in_date"));
                request.setAttribute("check_out_date", rs.getDate("check_out_date"));

                request.getRequestDispatcher("editReservation.jsp")
                        .forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String guestName = request.getParameter("guest_name");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact_number");
        String roomType = request.getParameter("room_type");
        String checkIn = request.getParameter("check_in_date");
        String checkOut = request.getParameter("check_out_date");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE reservation SET guest_name=?, address=?, contact_number=?, room_type=?, check_in_date=?, check_out_date=? WHERE reservation_id=?");

            ps.setString(1, guestName);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setString(4, roomType);
            ps.setString(5, checkIn);
            ps.setString(6, checkOut);
            ps.setInt(7, id);

            ps.executeUpdate();

            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}