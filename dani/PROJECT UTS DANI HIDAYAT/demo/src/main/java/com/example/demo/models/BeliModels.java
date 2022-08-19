package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pembelian")
public class BeliModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pembelian;

    @Column(name = "namaobat")
    private String namaobat;

    @Column(name = "hargabeli")
    private Integer hargabeli;

    @Column(name = "banyak")
    private Integer banyak;

    @Column(name = "subtotal")
    private Integer subtotal;

    @Column(name = "namapemasok")
    private String namapemasok;

    @Column(name = "tglbeli")
    private String tglbeli;
}