package com.company.hotel.model;

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
@Table(name="checkIn")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "tipe_kamar")
    private String tipe_kamar;

    @Column(name="fasilitas")
    private String fasilitas;

    @Column(name ="nama_pengunjung")
    private String nama_pengunjung;

    @Column(name="nama_karyawan")
    private String nama_karyawan;

    @Column(name="lama_menginap")
    private int lama_menginap;

}
