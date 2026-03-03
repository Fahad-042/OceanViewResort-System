package com.example.oceanviewresort.dao;

import com.oceanview.util.DBConnection;
import com.example.oceanviewresort.model.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public void addReservation(String guestName,
                               String address,
                               String contact,
                               String roomType,
                               LocalDate checkIn,
                               LocalDate checkOut) throws Exception {

        String sql = "INSERT INTO reservation " +
                "(guest_name, address, contact_number, room_type, check_in_date, check_out_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, guestName);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setString(4, roomType);
            ps.setDate(5, Date.valueOf(checkIn));
            ps.setDate(6, Date.valueOf(checkOut));
            ps.executeUpdate();
        }
    }

    @Override
    public void updateReservation(int id,
                                  String guestName,
                                  String address,
                                  String contact,
                                  String roomType,
                                  LocalDate checkIn,
                                  LocalDate checkOut) throws Exception {

        String sql = "UPDATE reservation SET " +
                "guest_name=?, address=?, contact_number=?, room_type=?, " +
                "check_in_date=?, check_out_date=? " +
                "WHERE reservation_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, guestName);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setString(4, roomType);
            ps.setDate(5, Date.valueOf(checkIn));
            ps.setDate(6, Date.valueOf(checkOut));
            ps.setInt(7, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteReservation(int id) throws Exception {

        String sql = "DELETE FROM reservation WHERE reservation_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Reservation getReservationById(int id) throws Exception {

        String sql = "SELECT * FROM reservation WHERE reservation_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Reservation(
                            rs.getInt("reservation_id"),
                            rs.getString("guest_name"),
                            rs.getString("address"),
                            rs.getString("contact_number"),
                            rs.getString("room_type"),
                            rs.getDate("check_in_date").toLocalDate(),
                            rs.getDate("check_out_date").toLocalDate()
                    );
                }
            }
        }

        return null;
    }

    @Override
    public List<Reservation> getAllReservations() throws Exception {

        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservation";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                list.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getString("guest_name"),
                        rs.getString("address"),
                        rs.getString("contact_number"),
                        rs.getString("room_type"),
                        rs.getDate("check_in_date").toLocalDate(),
                        rs.getDate("check_out_date").toLocalDate()
                ));
            }
        }

        return list;
    }
}