package com.example.repository;

import com.example.entity.Client;
import com.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findReservationById(Long id);
    Reservation findReservationByClient(Client client);

}
