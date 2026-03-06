package com.example.oceanviewresort.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Service class that handles business logic for reservations
 */
public class ReservationService {

    public long calculateNights(LocalDate checkIn, LocalDate checkOut) {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }
}