package com.example.service.impl;

import com.example.entity.Client;
import com.example.entity.Reservation;
import com.example.repository.ReservationRepository;
import com.example.service.InterfaceService;
import com.example.service.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationInterface {
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

    @Override
    public Reservation findByPrice(Long price) {
        return resRepository.findReservationByPrice(price);
    }

}
