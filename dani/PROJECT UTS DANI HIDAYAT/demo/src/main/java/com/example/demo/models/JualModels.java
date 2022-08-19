package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "penjualan")
public class JualModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_penjualan;

    @Column(name = "referal")
    private String referal;

    @Column(name = "namaobat")
    private String namaobat;

    @Column(name = "hargajual")
    private Integer hargajual;

    @Column(name = "banyak")
    private Integer banyak;

    @Column(name = "subtotal")
    private Integer subtotal;

    @Column(name = "namapembeli")
    private String namapembeli;

    @Column(name = "tglbeli")
    private String tglbeli;
}
