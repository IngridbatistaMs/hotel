package com.ingrid.hotel.service.impl;

import com.ingrid.hotel.domain.model.Room;
import com.ingrid.hotel.domain.repository.RoomRepository;
import com.ingrid.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public Room save(Room room) {
        return repository.save(room);
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Room> findAvailables() {
        return repository.findAvailables(LocalDate.now());
    }
}
