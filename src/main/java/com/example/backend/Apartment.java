package com.example.backend;

public class Apartment {
    private Long id;
    private String title;
    private Double price;
    private String city;
    private String district;

    public Apartment() {}

    public Apartment(Long id, String title, Double price, String city, String district) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.city = city;
        this.district = district;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
}