package com.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "lastname", nullable = true, length = 45)
    private String lastname;
    @Column(name = "speciality", nullable = true, length = 45)
    private String speciality;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity= Room.class, mappedBy = "staff", cascade = {CascadeType.ALL})
    private Collection<Room> rooms;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", speciality='" + speciality + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
