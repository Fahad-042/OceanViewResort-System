package com.example.oceanviewresort;

import com.example.oceanviewresort.dao.ReservationDAO;
import com.example.oceanviewresort.dao.ReservationDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteReservation")
public class DeleteReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            ReservationDAO dao = new ReservationDAOImpl();
            dao.deleteReservation(id);

            response.sendRedirect("viewReservations");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}