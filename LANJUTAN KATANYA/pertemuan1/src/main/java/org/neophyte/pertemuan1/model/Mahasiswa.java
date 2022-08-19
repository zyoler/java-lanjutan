package org.neophyte.pertemuan1.model;

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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nim")
    private String Nim;

    @Column(name = "nama")
    private String Nama;

    @Column(name="alamat")
    private String Alamat;

    @Column(name="jenisKelamin")
    private  String jenisKelamin;

    @Column(name ="jurusan")
    private String jurusan;

     @Column(name="nohp")
    private String nohp;

    @Column(name="email")
    private String email;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNim() {
//        return Nim;
//    }
//
//    public void setNim(String nim) {
//        Nim = nim;
//    }
//
//    public String getNama() {
//        return Nama;
//    }
//
//    public void setNama(String nama) {
//        Nama = nama;
//    }
//
//    public String getAlamat() {
//        return Alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        Alamat = alamat;
//    }
}
