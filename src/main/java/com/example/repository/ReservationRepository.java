package com.example.repository;

import com.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findReservationById(Long id);
    List<Reservation> findReservationByClientPassport(String clientPassport);
    Reservation findReservationByPrice(Long price);

}
