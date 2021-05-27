package com.example.controller;

import com.example.entity.Client;
import com.example.service.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Qualifier("clientServiceImpl")
    @Autowired
    ClientInterface resRepo;

    @RequestMapping(value = "/cli/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client res = this.resRepo.findById(id);
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/cli", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody Client res) {
        HttpHeaders headers = new HttpHeaders();
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.resRepo.save(res);
        return new ResponseEntity<>(res, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clie/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id) {
        Client res = this.resRepo.findById(id);

        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.resRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/clies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> res = this.resRepo.findAll();

        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
