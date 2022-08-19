package com.company.hotel.dto;

public class CheckInDto {
    private String tipe_kamar,fasilitas,nama_pengunjung,nama_karyawan;

    private int id,lama_menginap;

    public String getTipe_kamar() {
        return tipe_kamar;
    }

    public void setTipe_kamar(String tipe_kamar) {
        this.tipe_kamar = tipe_kamar;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getNama_pengunjung() {
        return nama_pengunjung;
    }

    public void setNama_pengunjung(String nama_pengunjung) {
        this.nama_pengunjung = nama_pengunjung;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLama_menginap() {
        return lama_menginap;
    }

    public void setLama_menginap(int lama_menginap) {
        this.lama_menginap = lama_menginap;
    }
}
