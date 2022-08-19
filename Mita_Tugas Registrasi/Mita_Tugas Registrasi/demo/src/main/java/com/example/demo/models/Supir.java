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
@Table(name = "supir")
public class Supir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supir;

    @Column(name = "nama_supir")
    private String nama_supir;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "harga_perhari")
    private Integer harga_perhari;

    @Column(name = "status")
    private String status;

    @Column(name = "foto_supir")
    private String foto_supir;

}
