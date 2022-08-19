package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peminjaman;

    @Column(name = "id_member")
    private Integer id_member;

    @Column(name="id_paket")
    private Integer id_paket;

    @Column(name="id_mobil")
    private Integer id_mobil;

    @Column(name="id_supir")
    private Integer id_supir;

    @Column(name = "tgl_peminjaman")
    private String tgl_peminjaman;

    @Column(name = "tgl_kembali")
    private String tgl_kembali;

    @Column(name = "total")
    private Integer total;

    @Column(name = "uang_muka")
    private Integer uang_muka;

    @Column(name = "diskon")
    private Integer diskon;

    @Column(name = "denda")
    private Integer denda;

    @Column(name = "lama")
    private Integer lama;

    @Column(name = "status")
    private String status;

    @Column(name = "nama_member")
    private String nama_member;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nama_mobil")
    private String nama_mobil;

    @Column(name = "nama_supir")
    private String nama_supir;
}
