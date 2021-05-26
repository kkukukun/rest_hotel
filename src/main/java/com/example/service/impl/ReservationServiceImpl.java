package com.example.service.impl;

import com.example.entity.Client;
import com.example.entity.Reservation;
import com.example.repository.ReservationRepository;
import com.example.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationServiceImpl implements InterfaceService<Reservation> {
    @Autowired
    ReservationRepository resRepository;

    @Override
    public void save(Reservation reservation) {
        resRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return resRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return resRepository.findReservationById(id);
    }

    @Override
    public void delete(Long id) {
    resRepository.deleteById(id);
    }

}
