package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "jenjang")
public class Jenjang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @JsonIgnore
    @OneToMany(mappedBy = "jenjang")
    private Set<ProgramStudi> programStudi;

}