package com.ingrid.hotel.domain.repository;

import com.ingrid.hotel.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT res FROM Reservation res WHERE " +
            "(res.checkIn BETWEEN :checkIn AND :checkOut) OR " +
            "(res.checkOut BETWEEN :checkIn AND :checkOut) OR " +
            "(res.checkIn <= :checkIn AND res.checkOut >= :checkOut)")
    List<Reservation> findByDate(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

    List<Reservation> findByGuestId(Long id);

    List<Reservation> findByRoomId(Long id);
}
