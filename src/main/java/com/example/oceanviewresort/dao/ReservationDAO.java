package com.example.oceanviewresort.dao;

import com.example.oceanviewresort.model.Reservation;
import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {

    void addReservation(String guestName,
                        String address,
                        String contact,
                        String roomType,
                        LocalDate checkIn,
                        LocalDate checkOut) throws Exception;
    // Insert reservation record into database
    void deleteReservation(int id) throws Exception;

    Reservation getReservationById(int id) throws Exception;

    void updateReservation(int id,
                           String guestName,
                           String address,
                           String contact,
                           String roomType,
                           LocalDate checkIn,
                           LocalDate checkOut) throws Exception;

    List<Reservation> getAllReservations() throws Exception;
}