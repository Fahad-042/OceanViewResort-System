package com.example.oceanviewresort.service;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceTest {

    @Test
    void shouldCalculateCorrectNumberOfNights() {
        ReservationService service = new ReservationService();

        LocalDate checkIn = LocalDate.of(2026, 2, 28);
        LocalDate checkOut = LocalDate.of(2026, 3, 2);

        long nights = service.calculateNights(checkIn, checkOut);

        assertEquals(2, nights);
    }
}