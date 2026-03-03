package com.example.oceanviewresort;

import com.example.oceanviewresort.dao.ReservationDAO;
import com.example.oceanviewresort.dao.ReservationDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {

    private ReservationDAO dao = new ReservationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("addReservation.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String guestName = request.getParameter("guest_name");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact_number");
            String roomType = request.getParameter("room_type");

            LocalDate checkIn = LocalDate.parse(request.getParameter("check_in"));
            LocalDate checkOut = LocalDate.parse(request.getParameter("check_out"));

            // Preserve values on error
            request.setAttribute("guest_name", guestName);
            request.setAttribute("address", address);
            request.setAttribute("contact_number", contact);
            request.setAttribute("room_type", roomType);
            request.setAttribute("check_in", checkIn);
            request.setAttribute("check_out", checkOut);

            // Contact validation
            if (!contact.matches("\\d{10}")) {
                request.setAttribute("error",
                        "Invalid Contact Number! Must be exactly 10 digits.");
                request.getRequestDispatcher("addReservation.jsp")
                        .forward(request, response);
                return;
            }



            // Date validation
            if (!checkOut.isAfter(checkIn)) {
                request.setAttribute("error",
                        "Check-out date must be after the check-in date.");
                request.getRequestDispatcher("addReservation.jsp")
                        .forward(request, response);
                return;
            }

            dao.addReservation(guestName, address, contact,
                    roomType, checkIn, checkOut);

            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}