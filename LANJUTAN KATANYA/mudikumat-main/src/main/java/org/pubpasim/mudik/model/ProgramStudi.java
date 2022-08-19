package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "program_studi")
public class ProgramStudi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "jenjang")
    private Jenjang jenjang;

    @ManyToOne
    @JoinColumn(name = "jurusan")
    private Jurusan jurusan;

    @JsonIgnore
    @OneToMany(mappedBy = "programStudi")
    private Set<Akun> penempuh;

}