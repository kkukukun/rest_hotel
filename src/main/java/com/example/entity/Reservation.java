package com.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "price", nullable = true, precision = 0)
    private Float price;
    @Column(name = "date", nullable = true)
    private Date date;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Room.class, mappedBy = "reservation", cascade = {CascadeType.ALL})
    private Collection<Room> rooms;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
                ", pooms=" + rooms +
                ", client=" + client +
                '}';
    }
}
