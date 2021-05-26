package com.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @Column(name = "date", nullable = true)
    private Date date;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Room.class, mappedBy = "director", cascade = {CascadeType.ALL})
    private Collection<Room> performances;
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Client client;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", performances=" + performances +
                ", cliente=" + client +
                '}';
    }
}
