package com.example.oceanviewresort;

import com.example.oceanviewresort.dao.ReservationDAO;
import com.example.oceanviewresort.dao.ReservationDAOImpl;
import com.example.oceanviewresort.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {

            ReservationDAO dao = new ReservationDAOImpl();
            Reservation reservation = dao.getReservationById(id);

            if (reservation == null) {
                response.getWriter().println("Reservation not found.");
                return;
            }

            String guestName = reservation.getGuestName();
            String roomType = reservation.getRoomType();
            LocalDate checkIn = reservation.getCheckInDate();
            LocalDate checkOut = reservation.getCheckOutDate();

            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

            if (nights <= 0) {
                response.getWriter().println("Invalid stay duration.");
                return;
            }

            double rate = 0;

            if (roomType.equals("Single")) {
                rate = 5000;
            } else if (roomType.equals("Double")) {
                rate = 8000;
            } else if (roomType.equals("Suite")) {
                rate = 12000;
            }

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}