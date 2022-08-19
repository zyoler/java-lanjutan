package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "jabatan")
public class Jabatan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @JsonIgnore
    @OneToMany(mappedBy = "jabatan")
    private Set<JabatanAkun> pejabat;

}