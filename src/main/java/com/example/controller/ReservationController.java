package com.example.controller;


import com.example.entity.Reservation;
import com.example.service.ClientInterface;
import com.example.service.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Qualifier("reservationServiceImpl")
    @Autowired
    ReservationInterface resRepo;
    @Autowired
    ClientInterface clientInterface;

    @RequestMapping(value = "/res/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getResById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Reservation res = this.resRepo.findById(id);
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/res", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation res) {
        HttpHeaders headers = new HttpHeaders();
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.resRepo.save(res);
        return new ResponseEntity<>(res, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/res/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id) {
        Reservation res = this.resRepo.findById(id);

        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.resRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/ress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> res = this.resRepo.findAll();

        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
   @RequestMapping(value = "/res/price/{price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservationByPrice(@PathVariable("price") Long price) {
        if (price == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Reservation res =  this.resRepo.findByPrice(price);

        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
