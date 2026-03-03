package com.example.oceanviewresort;

import com.example.oceanviewresort.dao.ReservationDAO;
import com.example.oceanviewresort.dao.ReservationDAOImpl;
import com.example.oceanviewresort.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/editReservation")
public class EditReservationServlet extends HttpServlet {

    private ReservationDAO dao = new ReservationDAOImpl();

    // ===============================
    // LOAD DATA INTO EDIT FORM
    // ===============================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reservation reservation = dao.getReservationById(id);

            if (reservation == null) {
                response.getWriter().println("Reservation not found");
                return;
            }

            request.setAttribute("reservation", reservation);
            request.getRequestDispatcher("editReservation.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // UPDATE DATA
    // ===============================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            String guestName = request.getParameter("guest_name");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact"); // ✅ FIXED
            String roomType = request.getParameter("room_type");

            LocalDate checkIn =
                    LocalDate.parse(request.getParameter("check_in_date"));
            LocalDate checkOut =
                    LocalDate.parse(request.getParameter("check_out_date"));

            Reservation reservation = dao.getReservationById(id);

            // CONTACT VALIDATION
            if (!contact.matches("\\d{10}")) {
                request.setAttribute("error", "Invalid Contact Number! Must be 10 digits.");
                request.setAttribute("reservation", reservation);
                request.getRequestDispatcher("editReservation.jsp").forward(request, response);
                return;
            }

            // DATE VALIDATION
            if (!checkOut.isAfter(checkIn)) {
                request.setAttribute("error", "Check-out date must be after check-in date.");
                request.setAttribute("reservation", reservation);
                request.getRequestDispatcher("editReservation.jsp").forward(request, response);
                return;
            }

            dao.updateReservation(id, guestName, address, contact,
                    roomType, checkIn, checkOut);

            // ✅ SUCCESS → GO BACK TO LIST
            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}