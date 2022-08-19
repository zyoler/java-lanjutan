package com.example.demo.Model;

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
@Table(name = "admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "nim")
    private String Nim;

    @Column(name = "nama")
    private String Nama;

    @Column(name = "alamat")
    private String Alamat;

    @Column(name = "jk")
    private String Jk;

    @Column(name = "jurusan")
    private String Jurusan;

    @Column(name = "telp")
    private String Telp;

    @Column(name = "email")
    private String Email;
}
