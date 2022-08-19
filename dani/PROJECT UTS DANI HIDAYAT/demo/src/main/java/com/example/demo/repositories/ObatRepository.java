package com.example.demo.repositories;

import com.example.demo.models.ObatModels;
import com.example.demo.models.PegawaiModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObatRepository extends JpaRepository<ObatModels, Integer> {
    @Query("FROM ObatModels ")
    public List<ObatModels> getObat();

    @Query(value = "SELECT nama FROM obat", nativeQuery = true)
    public List<String> getNama();

    @Query(value = "SELECT nama FROM kategori", nativeQuery = true)
    public List<String> getNamaKategori();

    @Query(value = "SELECT nama FROM pemasok", nativeQuery = true)
    public List<String> getNamaPemasok();

    @Query(value = "select * from obat where id_obat = :cariParam", nativeQuery = true)
    public ObatModels getObatById(@Param("cariParam") Integer cari);

    @Query(value = "select * from obat where id_obat like %:cariParam% or nama like %:cariParam% or unit like %:cariParam% or stok like %:cariParam% or kategori like %:cariParam% or hargabeli like %:cariParam% or hargajual like %:cariParam% or pemasok like %:cariParam%", nativeQuery = true)
    public List<ObatModels> getObat(@Param("cariParam") String cari);
}
