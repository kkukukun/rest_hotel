package com.example.service.impl;

import com.example.entity.Room;
import com.example.repository.RoomRepository;
import com.example.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements InterfaceService<Room>{
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
    public Room findByAllId(Long id) {
        return roomRepository.findRoomById(id);
    }

    @Override
    public void delete(Long id) {
    roomRepository.deleteById(id);
    }

    public Room findByNumber(int number) {
        return roomRepository.findRoomByNumber(number);
    }


}
