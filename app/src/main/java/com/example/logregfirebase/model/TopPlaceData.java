package com.example.logregfirebase.model;

public class TopPlaceData {

    String placeName;
    String countryName;
    String price;
    Integer imageUrl;

    Integer gambarBesar;

    public TopPlaceData(String placeName, String countryName, String price, Integer imageUrl, Integer gambarBesar) {
        this.placeName = placeName;
        this.countryName = countryName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.gambarBesar = gambarBesar;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getGambarBesar() {
        return gambarBesar;
    }

    public void setGambarBesar(Integer gambarBesar) {
        this.gambarBesar = gambarBesar;
    }

}
