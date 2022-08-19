package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "provinsi")
public class Provinsi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "lintang")
    private double lintang;

    @Column(name = "bujur")
    private double bujur;

    @JsonIgnore
    @OneToMany(mappedBy = "provinsi")
    private List<Kabupaten> kabupaten;

}