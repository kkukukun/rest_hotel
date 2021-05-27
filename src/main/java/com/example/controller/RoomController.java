package com.example.controller;

import com.example.entity.Room;
import com.example.service.RoomInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Qualifier("roomServiceImpl")
    @Autowired
    RoomInterface roomRepo;

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Room room = this.roomRepo.findById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        HttpHeaders headers = new HttpHeaders();
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.roomRepo.save(room);
        return new ResponseEntity<>(room, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Long id) {
        Room room = this.roomRepo.findById(id);

        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.roomRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Room>> getAllRoom() {
        List<Room> rooms = this.roomRepo.findAll();

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }


    }
