package org.neophyte.pertemuan1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_photo;

    @Column(name="url_small")
    private String url_small;

    @Column(name="url_medium")
    private String url_medium;

    @Column(name="url_large")
    private String url_large;

    @OneToOne(mappedBy = "photo")
    private  Book book;

}
