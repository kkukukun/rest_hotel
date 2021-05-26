package com.example.repository;

import com.example.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository  extends JpaRepository<Client, Long> {
    Client findClientById(Long in);
    Client findClientByName(String name);
    Client findClientByPassport(String passport);
}
