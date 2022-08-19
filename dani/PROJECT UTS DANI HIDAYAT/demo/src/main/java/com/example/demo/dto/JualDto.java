package com.example.demo.dto;

public class JualDto {

    private Integer id_penjualan, hargajual, banyak, subtotal, id_obat;
    private String referal, namaobat, namapembeli, tglbeli;

    public Integer getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(Integer id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public Integer getHargajual() {
        return hargajual;
    }

    public void setHargajual(Integer hargajual) {
        this.hargajual = hargajual;
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

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public String getReferal() {
        return referal;
    }

    public void setReferal(String referal) {
        this.referal = referal;
    }

    public String getNamaobat() {
        return namaobat;
    }

    public void setNamaobat(String namaobat) {
        this.namaobat = namaobat;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public String getTglbeli() {
        return tglbeli;
    }

    public void setTglbeli(String tglbeli) {
        this.tglbeli = tglbeli;
    }
}
