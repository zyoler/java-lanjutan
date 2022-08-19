package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "jabatan_akun")
public class JabatanAkun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "akun")
    private Akun akun;

    @ManyToOne
    @JoinColumn(name = "jabatan")
    private Jabatan jabatan;

    @ManyToOne
    @JoinColumn(name = "divisi")
    private Divisi divisi;

    @ManyToOne
    @JoinColumn(name = "organisasi")
    private Organisasi organisasi;

    @Column(name = "awal_menjabat")
    private Integer awalMenjabat;

    @Column(name = "akhir_menjabat")
    private Integer akhirMenjabat;

}