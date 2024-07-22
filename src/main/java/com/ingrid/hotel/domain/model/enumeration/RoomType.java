package com.ingrid.hotel.domain.model.enumeration;

public enum RoomType {

    DOUBLE("Double", 2), TRIPLE("Triple", 3), FAMILY("Family", 5);

    private String value;
    private int capacity;

    RoomType(String value, int capacity){
        this.value = value;
        this.capacity = capacity;
    }

    public String getValue() {
        return value;
    }

    public int getCapacity(){
        return capacity;
    }
}
