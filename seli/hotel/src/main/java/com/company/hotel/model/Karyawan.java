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
@Table(name="karyawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="no_ktp")
    private String no_ktp;

    @Column(name="nama_karyawan")
    private String nama_karyawan;

    @Column(name="jenis_kelamin")
    private String jenis_kelamin;

    @Column(name="alamat")
    private String alamat;

    @Column(name="email")
    private String email;

    @Column(name="no_telp")
    private String no_telp;

    public int getId() {
        return id;
    }
}
