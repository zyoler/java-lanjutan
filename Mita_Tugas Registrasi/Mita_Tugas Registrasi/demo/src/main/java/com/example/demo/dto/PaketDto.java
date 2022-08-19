package com.example.demo.dto;

public class PaketDto {
    private Integer id_paket, diskon, lama_rental;
    private String nama_paket;

    public Integer getId_paket() {
        return id_paket;
    }

    public void setId_paket(Integer id_paket) {
        this.id_paket = id_paket;
    }

    public Integer getDiskon() {
        return diskon;
    }

    public void setDiskon(Integer diskon) {
        this.diskon = diskon;
    }

    public Integer getLama_rental() {
        return lama_rental;
    }

    public void setLama_rental(Integer lama_rental) {
        this.lama_rental = lama_rental;
    }

    public String getNama_paket() {
        return nama_paket;
    }

    public void setNama_paket(String nama_paket) {
        this.nama_paket = nama_paket;
    }
}
