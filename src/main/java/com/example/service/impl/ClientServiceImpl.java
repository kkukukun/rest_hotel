package com.example.service.impl;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import com.example.service.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientInterface {

    @Autowired
    ClientRepository clientRepo;

    @Override
    public void save(Client client) {
        clientRepo.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepo.findClientById(id);
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    public Client findByName(String name) {
        return clientRepo.findClientByName(name);
    }
    public Client findByPassport(String passport){return  clientRepo.findClientByPassport(passport);}
}
