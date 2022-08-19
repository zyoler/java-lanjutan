package com.company.hotel.model;

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
@Table(name="kamar")
public class Kamar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="tipe_kamar")
    private String tipe_kamar;

    @Column(name="fasilitas")
    private String fasilitas;

    @Column(name="harga")
    private String harga;

    @Column(name="kapasitas")
    private String kapasitas;

    @Column(name="status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
