package com.example.backend;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

// Kennzeichnet die Klasse als Tabelle in der PostgreSQL-Datenbank
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private String priceSuffix; // z.B. "/ Monat" oder "/ Tag"
    private String type;        // "Langzeit" oder "Kurzzeit"
    private String city;
    private String district;
    private String space;       // z.B. "18 m²"
    private String phone;

    @Column(length = 2000)
    private String description;

    @Column(length = 1000)
    private String imageUrl;

    // Echte Account-Daten des Vermieters
    private String landlordName;
    private String memberSince;

    // Echter System-Zeitstempel vom Server (für "Neu", "vor 5 Min.", "vor 2 Std.")
    private Instant createdAt;

    // Wird automatisch vor dem Speichern in PostgreSQL ausgeführt
    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = Instant.now();
        }
        if (this.memberSince == null || this.memberSince.isEmpty()) {
            this.memberSince = "2026";
        }
        if (this.landlordName == null || this.landlordName.isEmpty()) {
            this.landlordName = "Student_Vermieter";
        }
    }

    public Apartment() {
    }

    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPriceSuffix() { return priceSuffix; }
    public void setPriceSuffix(String priceSuffix) { this.priceSuffix = priceSuffix; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getSpace() { return space; }
    public void setSpace(String space) { this.space = space; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getLandlordName() { return landlordName; }
    public void setLandlordName(String landlordName) { this.landlordName = landlordName; }

    public String getMemberSince() { return memberSince; }
    public void setMemberSince(String memberSince) { this.memberSince = memberSince; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}