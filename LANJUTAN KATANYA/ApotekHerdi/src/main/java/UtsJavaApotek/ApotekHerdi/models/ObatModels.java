package UtsJavaApotek.ApotekHerdi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="table_med")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObatModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_obat", nullable = true, unique = true)
    private Integer id_obat;

    @Column(name = "nama_obat")
    private String nama_obat;

    @Column(name = "penyimpanan")
    private String penyimpanan;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "unit")
    private String unit;

    @Column(name = "nama_kategori")
    private String nama_kategori;

    @Column(name = "kedaluwarsa")
    private String kedaluwarsa;

    @Column(name = "des_obat")
    private String des_obat;

    @Column(name = "harga_beli")
    private Integer harga_beli;

    @Column(name = "harga_jual")
    private Integer harga_jual;

    @Column(name = "nama_pemasok")
    private String nama_pemasok;

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

    public String getKedaluwarsa() {
        return kedaluwarsa;
    }

    public void setKedaluwarsa(String kedaluwarsa) {
        this.kedaluwarsa = kedaluwarsa;
    }

    public String getDes_obat() {
        return des_obat;
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
