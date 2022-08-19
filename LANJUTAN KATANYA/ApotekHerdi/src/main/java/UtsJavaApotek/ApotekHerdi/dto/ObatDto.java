package UtsJavaApotek.ApotekHerdi.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObatDto {
    Integer id_obat;
    String nama_obat;
    String penyimpanan;
    Integer stok;
    String unit;
    String nama_kategori;
    String kedaluwarsa;
    String des_obat;
    Integer harga_beli;
    Integer harga_jual;
    String nama_pemasok;

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getPenyimpanan() {
        return penyimpanan;
    }

    public void setPenyimpanan(String penyimpanan) {
        this.penyimpanan = penyimpanan;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getDes_obat() {
        return des_obat;
    }

    public String getKedaluwarsa() {
        return kedaluwarsa;
    }

    public void setKedaluwarsa(String kedaluwarsa) {
        this.kedaluwarsa = kedaluwarsa;
    }

    public void setDes_obat(String des_obat) {
        this.des_obat = des_obat;
    }

    public Integer getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(Integer harga_beli) {
        this.harga_beli = harga_beli;
    }

    public Integer getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Integer harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok(String nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }

}
