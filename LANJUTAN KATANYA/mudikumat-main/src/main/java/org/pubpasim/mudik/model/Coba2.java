package org.pubpasim.mudik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "coba2")
public class Coba2 {

    @Id
    @Column(name = "id")
    private String id;

}
