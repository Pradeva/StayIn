package com.example.logregfirebase.model;

public class Kupon {
    private String kode;
    String potongan;

    public Kupon(String kode, String potongan) {
        this.kode = kode;
        this.potongan = potongan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
