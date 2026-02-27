package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("addReservation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String guestName = request.getParameter("guest_name");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact_number");
        String roomType = request.getParameter("room_type");
        String checkIn = request.getParameter("check_in");
        String checkOut = request.getParameter("check_out");


        // Contact number validation
        if (!contact.matches("\\d{10}")) {
            response.getWriter().println("Invalid Contact Number! Must be 10 digits.");
            return;
        }

// Date validation
        LocalDate inDate = LocalDate.parse(checkIn);
        LocalDate outDate = LocalDate.parse(checkOut);

        long nights = ChronoUnit.DAYS.between(inDate, outDate);

        if (nights <= 0) {
            response.getWriter().println("Check-out date must be after check-in date.");
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO reservation " +
                    "(guest_name, address, contact_number, room_type, check_in_date, check_out_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, guestName);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setString(4, roomType);
            ps.setString(5, checkIn);
            ps.setString(6, checkOut);

            ps.executeUpdate();

            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}