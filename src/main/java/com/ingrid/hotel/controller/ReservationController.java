package com.ingrid.hotel.controller;

import com.ingrid.hotel.domain.model.Reservation;
import com.ingrid.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservationToCreate){
        var reservationCreated = service.save(reservationToCreate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservationCreated.getId())
                .toUri();

        return  ResponseEntity.created(location).body(reservationCreated);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{checkIn}/{checkOut}")
    public ResponseEntity<List<Reservation>> findByDate(@PathVariable LocalDate checkIn, LocalDate checkOut){
        return ResponseEntity.ok(service.findByDate(checkIn, checkOut));
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<List<Reservation>> findByGuest(@PathVariable Long id){
        return ResponseEntity.ok(service.findByGuest(id));
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<List<Reservation>> findByRoom(@PathVariable Long id){
        return ResponseEntity.ok(service.findByRoom(id));
    }
}
