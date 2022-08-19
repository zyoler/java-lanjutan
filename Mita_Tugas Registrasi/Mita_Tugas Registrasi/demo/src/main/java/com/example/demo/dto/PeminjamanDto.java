package com.example.demo.dto;

public class PeminjamanDto {
    private Integer id_peminjaman,id_member,id_paket,id_mobil,id_supir,total,uang_muka,diskon,denda,lama;
    private String tgl_peminjaman,tgl_kembali,status,nama_member,no_telp,alamat,nama_mobil,nama_supir;

    public Integer getId_peminjaman() {
        return id_peminjaman;
    }

    public void setId_peminjaman(Integer id_peminjaman) {
        this.id_peminjaman = id_peminjaman;
    }

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
    }

    public Integer getId_paket() {
        return id_paket;
    }

    public String getNama_member() {
        return nama_member;
    }

    public void setNama_member(String nama_member) {
        this.nama_member = nama_member;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setId_paket(Integer id_paket) {
        this.id_paket = id_paket;
    }

    public Integer getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(Integer id_mobil) {
        this.id_mobil = id_mobil;
    }

    public Integer getId_supir() {
        return id_supir;
    }

    public void setId_supir(Integer id_supir) {
        this.id_supir = id_supir;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUang_muka() {
        return uang_muka;
    }

    public void setUang_muka(Integer uang_muka) {
        this.uang_muka = uang_muka;
    }

    public Integer getDiskon() {
        return diskon;
    }

    public void setDiskon(Integer diskon) {
        this.diskon = diskon;
    }

    public Integer getDenda() {
        return denda;
    }

    public void setDenda(Integer denda) {
        this.denda = denda;
    }

    public Integer getLama() {
        return lama;
    }

    public void setLama(Integer lama) {
        this.lama = lama;
    }

    public String getTgl_peminjaman() {
        return tgl_peminjaman;
    }

    public void setTgl_peminjaman(String tgl_peminjaman) {
        this.tgl_peminjaman = tgl_peminjaman;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getNama_supir() {
        return nama_supir;
    }

    public void setNama_supir(String nama_supir) {
        this.nama_supir = nama_supir;
    }
}
