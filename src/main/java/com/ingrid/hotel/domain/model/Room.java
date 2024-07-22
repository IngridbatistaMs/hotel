package com.ingrid.hotel.domain.model;

import com.ingrid.hotel.domain.model.enumeration.RoomType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;

    @Column(scale = 2, nullable = false)
    private BigDecimal price;

    public Room() {
    }

    public Room(RoomType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
