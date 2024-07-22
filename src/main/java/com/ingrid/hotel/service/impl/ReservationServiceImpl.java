package com.ingrid.hotel.service.impl;

import com.ingrid.hotel.domain.model.Reservation;
import com.ingrid.hotel.domain.repository.ReservationRepository;
import com.ingrid.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> findByDate(LocalDate checkIn, LocalDate checkOut) {
        return repository.findByDate(checkIn, checkOut);
    }

    @Override
    public List<Reservation> findByGuest(Long guestId) {
        return repository.findByGuestId(guestId);
    }

    @Override
    public List<Reservation> findByRoom(Long roomId) {
        return repository.findByRoomId(roomId);
    }
}