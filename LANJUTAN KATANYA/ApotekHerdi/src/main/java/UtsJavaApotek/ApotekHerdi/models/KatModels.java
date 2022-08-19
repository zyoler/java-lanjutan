package UtsJavaApotek.ApotekHerdi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="table_cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KatModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_kat", nullable = true, unique = true)
    private Integer id_kat;

    @Column(name = "nama_kategori")
    private String nama_kategori;

    @Column(name = "des_kat")
    private String des_kat;

    public Integer getId_kat() {
        return id_kat;
    }

    public void setId_kat(Integer id_kat) {
        this.id_kat = id_kat;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getDes_kat() {
        return des_kat;
    }

    public void setDes_kat(String des_kat) {
        this.des_kat = des_kat;
    }
}
