package org.pubpasim.mudik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "coba1")
public class Coba1 {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "coba2")
    private Coba2 coba2;

}
