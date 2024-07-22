package com.ingrid.hotel.service;

import com.ingrid.hotel.domain.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Reservation findById(Long id);

    List<Reservation> findAll();

    List<Reservation> findByDate(LocalDate checkIn, LocalDate checkOut);

    List<Reservation> findByGuest(Long guestId);

    List<Reservation> findByRoom(Long id);
}
