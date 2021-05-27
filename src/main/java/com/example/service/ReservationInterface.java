package com.example.service;

import com.example.entity.Reservation;

import java.util.List;

public interface ReservationInterface extends InterfaceService<Reservation>{
    Reservation findByPrice(Long price);
    List<Reservation> findByClientPassport(String clientPassport);
}
