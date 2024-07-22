package com.ingrid.hotel.service;

import com.ingrid.hotel.domain.model.Room;

import java.util.List;

public interface RoomService {

    Room save(Room rom);

    void delete(Long id);

    List<Room> findAll();

    Room findById(Long id);

    List<Room> findAvailables();
}
