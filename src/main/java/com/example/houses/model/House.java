package com.example.houses.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class House {
    private String id;
    private String address;
    private Double latitude;
    private Double longitude;

    @JsonProperty("lastSalePrice")
    private Double price;

    @JsonProperty("squareFootage")
    private Double squareFootage;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getSquareFootage() { return squareFootage; }
    public void setSquareFootage(Double squareFootage) { this.squareFootage = squareFootage; }

    public Double getCostPerSquareFoot() {
        if (squareFootage == null || squareFootage == 0) return null;
        return price / squareFootage;
    }
}