package org.pubpasim.mudik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.pubpasim.mudik.model.common.ReferenceBase;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mudik")
public class Mudik extends ReferenceBase {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "berangkat")
    private Date berangkat;

    @Column(name = "kembali")
    private Date kembali;

    @ManyToOne
    @JoinColumn(name = "tujuan")
    private Kabupaten tujuan;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private Akun pemudik;

    @Transient
    private String namaPemudik;

}