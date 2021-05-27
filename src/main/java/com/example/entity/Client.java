package com.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "surname", nullable = true, length = 45)
    private String surname;
    @Column(name = "telephone", nullable = true, length = 45)
    private String telephone;
    @Column(name = "passport", nullable = true, length = 45)
    private String passport;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Reservation.class, mappedBy = "client", cascade = {CascadeType.ALL})
    private Collection<Reservation> reservations;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }


}
