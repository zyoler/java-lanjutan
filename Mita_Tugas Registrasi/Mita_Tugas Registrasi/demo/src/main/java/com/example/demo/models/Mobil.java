package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mobil")
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mobil;

    @Column(name = "nama_mobil")
    private String nama_mobil;

    @Column(name = "merk")
    private String merk;

    @Column(name = "warna")
    private String warna;

    @Column(name = "tahun")
    private String tahun;

    @Column(name = "seri_kota")
    private String seri_kota;

    @Column(name = "no_polisi")
    private Integer no_polisi;

    @Column(name = "huruf")
    private String huruf;

    @Column(name = "status")
    private String status;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "foto_mobil")
    private String foto_mobil;
}
