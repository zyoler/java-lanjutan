package com.example.demo.dto;

public class BeliDto {
    private Integer id_pembelian, hargabeli, banyak, subtotal;
    private String namaobat, namapemasok, tglbeli;

    public Integer getId_pembelian() {
        return id_pembelian;
    }

    public void setId_pembelian(Integer id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public Integer getHargabeli() {
        return hargabeli;
    }

    public void setHargabeli(Integer hargabeli) {
        this.hargabeli = hargabeli;
    }

    public Integer getBanyak() {
        return banyak;
    }

    public void setBanyak(Integer banyak) {
        this.banyak = banyak;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public String getNamaobat() {
        return namaobat;
    }

    public void setNamaobat(String namaobat) {
        this.namaobat = namaobat;
    }

    public String getNamapemasok() {
        return namapemasok;
    }

    public void setNamapemasok(String namapemasok) {
        this.namapemasok = namapemasok;
    }

    public String getTglbeli() {
        return tglbeli;
    }

    public void setTglbeli(String tglbeli) {
        this.tglbeli = tglbeli;
    }
}
