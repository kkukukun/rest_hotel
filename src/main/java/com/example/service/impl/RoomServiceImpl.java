package com.example.service.impl;

import com.example.entity.Room;
import com.example.repository.RoomRepository;
import com.example.service.InterfaceService;
import com.example.service.RoomInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomInterface{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findRoomById(id);
    }

    @Override
    public void delete(Long id) {
    roomRepository.deleteById(id);
    }

    @Override
    public Room findByNumber(Integer number) {
        return roomRepository.findRoomByNumber(number);
    }
}
