package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "angkatan")
public class Angkatan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nomor")
    private int nomor;

    @Column(name = "nama")
    private String nama;

    @Column(name = "yel_yel")
    private String yelYel;

    @JsonIgnore
    @OneToMany(mappedBy = "angkatan")
    private Set<Akun> akun;

}