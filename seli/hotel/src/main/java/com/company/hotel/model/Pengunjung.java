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
@Table(name="pengunjung")
public class Pengunjung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name="no_ktp")
    private String no_ktp;

    @Column(name="nama_pengunjung")
    private String nama_pengunjung;

    @Column(name="jenis_kelamin")
    private String jenis_kelamin;

    @Column(name="alamat")
    private String alamat;

    @Column(name="email")
    private String email;

    @Column(name="no_hp")
    private String no_hp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
