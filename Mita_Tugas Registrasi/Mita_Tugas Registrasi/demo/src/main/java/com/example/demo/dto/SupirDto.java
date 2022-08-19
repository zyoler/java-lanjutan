package com.example.demo.dto;

public class SupirDto {
    private Integer id_supir, harga_perhari;
    private String nama_supir,alamat,no_telp,status,foto_supir;

    public Integer getId_supir() {
        return id_supir;
    }

    public void setId_supir(Integer id_supir) {
        this.id_supir = id_supir;
    }

    public Integer getHarga_perhari() {
        return harga_perhari;
    }

    public void setHarga_perhari(Integer harga_perhari) {
        this.harga_perhari = harga_perhari;
    }

    public String getNama_supir() {
        return nama_supir;
    }

    public void setNama_supir(String nama_supir) {
        this.nama_supir = nama_supir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoto_supir() {
        return foto_supir;
    }

    public void setFoto_supir(String foto_supir) {
        this.foto_supir = foto_supir;
    }
}
