package UtsJavaApotek.ApotekHerdi.dto;

import javax.persistence.criteria.CriteriaBuilder;

public class SuppDto {
    Integer id_pem;
    String nama_pemasok;
    String alamat;
    String telepon;

    public Integer getId_pem() {
        return id_pem;
    }

    public void setId_pem(Integer id_pem) {
        this.id_pem = id_pem;
    }

    public String getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok(String nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
