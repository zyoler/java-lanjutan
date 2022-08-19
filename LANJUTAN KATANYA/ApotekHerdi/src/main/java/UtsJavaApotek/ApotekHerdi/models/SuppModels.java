package UtsJavaApotek.ApotekHerdi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="table_sup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pem", nullable = true, unique = true)
    private Integer id_pem;

    @Column(name = "nama_pemasok")
    private String nama_pemasok;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "telepon")
    private String telepon;

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
