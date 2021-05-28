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
    ClientInterface clientInterface;

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client client = this.clientInterface.findById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        HttpHeaders headers = new HttpHeaders();
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.clientInterface.save(client);
        return new ResponseEntity<>(client, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id) {
        Client client = this.clientInterface.findById(id);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.clientInterface.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = this.clientInterface.findAll();

        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @RequestMapping(value = "/client/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientByName(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Client client = this.clientInterface.findByName(name);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @RequestMapping(value = "/client/passport/{passport}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteClientByPassport(@PathVariable("passport") String passport) {
        Client client = this.clientInterface.findByPassport(passport);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.clientInterface.delete(client.getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
