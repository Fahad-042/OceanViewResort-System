package com.example.oceanviewresort;

import com.example.oceanviewresort.dao.ReservationDAO;
import com.example.oceanviewresort.dao.ReservationDAOImpl;
import com.example.oceanviewresort.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewReservations")
public class ViewReservationServlet extends HttpServlet {

    private ReservationDAO dao = new ReservationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Reservation> reservations = dao.getAllReservations();
            request.setAttribute("reservations", reservations);

            request.getRequestDispatcher("viewReservations.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}