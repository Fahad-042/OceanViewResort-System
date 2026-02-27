package com.example.oceanviewresort;

import com.oceanview.util.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {

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

                String guestName = rs.getString("guest_name");
                String roomType = rs.getString("room_type");

                LocalDate checkIn = rs.getDate("check_in_date").toLocalDate();
                LocalDate checkOut = rs.getDate("check_out_date").toLocalDate();

                long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

                double rate = 0;

                if (nights <= 0) {
                    response.getWriter().println("Invalid stay duration. Check-out must be after check-in.");
                    return;
                }

                if(roomType.equals("Single")) rate = 5000;
                else if(roomType.equals("Double")) rate = 8000;
                else if(roomType.equals("Suite")) rate = 12000;

                double total = nights * rate;

                request.setAttribute("guestName", guestName);
                request.setAttribute("roomType", roomType);
                request.setAttribute("checkIn", checkIn);
                request.setAttribute("checkOut", checkOut);
                request.setAttribute("nights", nights);
                request.setAttribute("rate", rate);
                request.setAttribute("total", total);

                request.getRequestDispatcher("bill.jsp")
                        .forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}