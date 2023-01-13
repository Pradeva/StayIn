package com.example.logregfirebase.model;

import com.example.logregfirebase.DetailsActivity;

public class HistoryData {
    String placeName;
    String countryName;
    String price;
    Integer gambarBesar;
    //tambahan
    DetailsActivity detail;

    public HistoryData(String placeName, String countryName, String price, Integer gambarBesar) {
        this.placeName = placeName;
        this.countryName = countryName;
        this.price = price;
        this.gambarBesar = gambarBesar;
    }

    //tambahan
    public HistoryData(HistoryData dataRiwayat) {
        this.placeName = dataRiwayat.placeName;
        this.countryName = dataRiwayat.countryName;
        this.price = dataRiwayat.price;
        this.gambarBesar = dataRiwayat.gambarBesar;
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
