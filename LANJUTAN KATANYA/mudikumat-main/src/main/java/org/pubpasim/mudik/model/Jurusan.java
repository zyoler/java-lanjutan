package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "jurusan")
public class Jurusan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @ManyToOne
    @JoinColumn(name = "fakultas")
    private Fakultas fakultas;

    @JsonIgnore
    @OneToMany(mappedBy = "jurusan")
    private Set<ProgramStudi> programStudi;

}