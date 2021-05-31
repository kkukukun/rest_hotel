package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "amount", nullable = true)
    private Integer amount;
    @Column(name = "type_of_room", nullable = true, length = 45)
    private String typeOfRoom;

    @ManyToOne
    @JoinColumn(name="id_staff")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name="id_reservation")
    @JsonIgnoreProperties(value = {"rooms", "client"}, allowSetters = true)
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
