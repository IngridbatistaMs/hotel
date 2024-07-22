package com.ingrid.hotel.domain.repository;

import com.ingrid.hotel.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE NOT EXISTS (" +
            "SELECT res FROM Reservation res WHERE res.room = r AND " +
            "(:currentDate BETWEEN res.checkIn AND res.checkOut OR :currentDate = res.checkOut)" +
            ")")
    List<Room> findAvailables(@Param("currentDate") LocalDate currentDate);
}
