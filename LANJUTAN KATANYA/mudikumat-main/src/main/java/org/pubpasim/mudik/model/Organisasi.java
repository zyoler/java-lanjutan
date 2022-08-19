package org.pubpasim.mudik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organisasi")
public class Organisasi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "akronim")
    private String akronim;

}