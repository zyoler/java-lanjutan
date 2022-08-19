package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "kabupaten")
public class Kabupaten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "lintang")
    private double lintang;

    @Column(name = "bujur")
    private double bujur;

    @ManyToOne
    @JoinColumn(name = "provinsi")
    private Provinsi provinsi;

    @JsonIgnore
    @OneToMany(mappedBy = "daerahAsal")
    private List<Akun> penduduk;

    @JsonIgnore
    @OneToMany(mappedBy = "tujuan")
    private List<Mudik> mudik;

    @Transient
    private List<String> daftarNamaPemudik;

}