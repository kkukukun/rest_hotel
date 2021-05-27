package com.example.service;

import com.example.entity.Room;

public interface RoomInterface extends InterfaceService <Room>{
    Room findByNumber(Integer number);
}
