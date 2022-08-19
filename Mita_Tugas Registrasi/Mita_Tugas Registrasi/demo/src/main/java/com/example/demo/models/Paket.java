package com.example.demo.models;

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
@Table(name = "paket")
public class Paket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paket;

    @Column(name = "nama_paket")
    private String nama_paket;

    @Column(name = "diskon")
    private Integer diskon;

    @Column(name = "lama_rental")
    private Integer lama_rental;

}
