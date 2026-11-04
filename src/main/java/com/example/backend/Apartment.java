package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Kennzeichnet die Klasse als Tabelle in der PostgreSQL-Datenbank
@Entity
public class Apartment {

    // Definiert die ID als Primärschlüssel
    @Id
    // Die Datenbank vergibt die IDs automatisch fortlaufend
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private String city;
    private String district;

    // Leerer Standard-Konstruktor (wird zwingend von JPA benötigt)
    public Apartment() {
    }

    // Konstruktor mit allen Attributen
    public Apartment(Long id, String title, double price, String city, String district) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.city = city;
        this.district = district;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}