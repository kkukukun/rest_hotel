package com.example.service;

import com.example.entity.Client;

public interface ClientInterface extends InterfaceService<Client> {
     Client findByName(String name);
     Client findByPassport(String passport);
}
