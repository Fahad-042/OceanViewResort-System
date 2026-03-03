package com.example.oceanviewresort.dao;

import com.example.oceanviewresort.model.Reservation;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReservationDAOImplTest {

    private ReservationDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ReservationDAOImpl();
    }

    // Clean table before each test
    @BeforeEach
    void cleanDatabase() throws Exception {
        try (Connection con = com.oceanview.util.DBConnection.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DELETE FROM reservation");
        }
    }

    @Test
    @Order(1)
    void testAddReservation() throws Exception {

        dao.addReservation(
                "Test User",
                "Test Address",
                "0771234567",
                "Deluxe",
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        List<Reservation> list = dao.getAllReservations();

        assertEquals(1, list.size());
        assertEquals("Test User", list.get(0).getGuestName());
    }

    @Test
    @Order(2)
    void testGetAllReservations() throws Exception {

        dao.addReservation(
                "User One",
                "Address One",
                "0711111111",
                "Standard",
                LocalDate.now(),
                LocalDate.now().plusDays(1)
        );

        dao.addReservation(
                "User Two",
                "Address Two",
                "0722222222",
                "Deluxe",
                LocalDate.now(),
                LocalDate.now().plusDays(3)
        );

        List<Reservation> list = dao.getAllReservations();

        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    @Order(3)
    void testUpdateReservation() throws Exception {

        dao.addReservation(
                "Old Name",
                "Old Address",
                "0770000000",
                "Standard",
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        Reservation reservation = dao.getAllReservations().get(0);

        dao.updateReservation(
                reservation.getId(),
                "New Name",
                "New Address",
                "0779999999",
                "Deluxe",
                LocalDate.now(),
                LocalDate.now().plusDays(4)
        );

        Reservation updated = dao.getReservationById(reservation.getId());

        assertEquals("New Name", updated.getGuestName());
        assertEquals("Deluxe", updated.getRoomType());
    }

    @Test
    @Order(4)
    void testDeleteReservation() throws Exception {

        dao.addReservation(
                "Delete User",
                "Delete Address",
                "0766666666",
                "Standard",
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        Reservation reservation = dao.getAllReservations().get(0);

        dao.deleteReservation(reservation.getId());

        List<Reservation> list = dao.getAllReservations();

        assertEquals(0, list.size());
    }
}