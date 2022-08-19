package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "akun")
public class Akun {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama_pengguna", unique = true)
    private String namaPengguna;

    @Column(name = "kata_sandi")
    private String kataSandi;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private byte jenisKelamin;

    @ManyToOne
    @JoinColumn(name = "daerah_asal")
    private Kabupaten daerahAsal;

    @ManyToOne
    @JoinColumn(name = "tempat_lahir")
    private Kabupaten tempatLahir;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @ManyToOne
    @JoinColumn(name = "program_studi")
    private ProgramStudi programStudi;

    @ManyToOne
    @JoinColumn(name = "angkatan")
    private Angkatan angkatan;

    @OneToMany(mappedBy = "akun")
    private List<JabatanAkun> jabatan;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private Mudik mudik;

}