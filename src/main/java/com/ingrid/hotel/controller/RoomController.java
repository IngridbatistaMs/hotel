package com.ingrid.hotel.controller;

import com.ingrid.hotel.domain.model.Room;
import com.ingrid.hotel.domain.model.dto.RoomCreateDTO;
import com.ingrid.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Room>> findAll(){
        var rooms = service.findAll();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/availables")
    public ResponseEntity<List<Room>> findAvailable(){
        var rooms = service.findAvailables();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id){
        var room = service.findById(id);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody RoomCreateDTO roomToCreate){
        var roomCreated = service.save(roomToCreate.toRoom());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(roomCreated.getId())
                .toUri();

        return  ResponseEntity.created(location).body(roomCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
