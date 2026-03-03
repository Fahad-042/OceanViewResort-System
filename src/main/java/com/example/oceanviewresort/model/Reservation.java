package com.example.oceanviewresort.model;

import java.time.LocalDate;

public class Reservation {

    private int id;
    private String guestName;
    private String address;
    private String contact;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    // Constructor
    public Reservation(int id,
                       String guestName,
                       String address,
                       String contact,
                       String roomType,
                       LocalDate checkInDate,
                       LocalDate checkOutDate) {

        this.id = id;
        this.guestName = guestName;
        this.address = address;
        this.contact = contact;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // =========================
    // GETTERS
    // =========================

    public int getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getRoomType() {
        return roomType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}