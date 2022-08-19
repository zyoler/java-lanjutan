package org.pubpasim.mudik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "divisi")
public class Divisi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @ManyToOne
    @JoinColumn(name = "organisasi")
    private Organisasi organisasi;

}