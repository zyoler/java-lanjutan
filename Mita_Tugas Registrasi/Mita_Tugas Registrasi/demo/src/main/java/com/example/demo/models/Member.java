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
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_member;

    @Column(name = "no_ktp")
    private String no_ktp;

    @Column(name = "nama_member")
    private String nama_member;

    @Column(name = "tgl_lahir")
    private String tgl_lahir;

    @Column(name = "no_telpon")
    private String no_telpon;

    @Column(name = "jenis_kelamin")
    private String jenis_kelamin;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "foto_member")
    private String foto_member;
}
