package org.pubpasim.mudik.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class EntityBase {

    @Column(name = "deskripsi")
    private String deskripsi;

}
