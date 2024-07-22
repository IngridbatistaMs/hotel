package com.ingrid.hotel.domain.model.dto;

import com.ingrid.hotel.domain.model.Room;
import com.ingrid.hotel.domain.model.enumeration.RoomType;

import java.math.BigDecimal;

public class RoomCreateDTO {
    private RoomType type;
    private BigDecimal price;

    public RoomCreateDTO(RoomType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public Room toRoom(){
        return new Room(type, price);
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
