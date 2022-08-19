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
@Table(name = "mahasiswa")

public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nim")
    private String Nim;

    @Column(name = "nama")
    private String Nama;

    @Column(name = "jk")
    private String Jk;

    @Column(name = "jurusan")
    private String Jurusan;

    @Column(name = "nohp")
    private String Nohp;

    @Column(name = "email")
    private String Email;

    @Column(name = "alamat")
    private String Alamat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJk() {
        return Jk;
    }

    public void setJk(String jk) {
        Jk = jk;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setJurusan(String jurusan) {
        Jurusan = jurusan;
    }

    public String getNohp() {
        return Nohp;
    }

    public void setNohp(String nohp) {
        Nohp = nohp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }
}
