package com.example.demo.repositories;

import com.example.demo.models.PegawaiModels;
import com.example.demo.models.PelangganModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PelangganRepository extends JpaRepository<PelangganModels, Integer> {
    @Query("FROM PelangganModels")
    public List<PelangganModels> getPelanggan();

    @Query(value = "select * from pelanggan where id_peg like %:cariParam% or nama like %:cariParam% or jk like %:cariParam% or alamat like %:cariParam% or nohp like %:cariParam% or email like %:cariParam%", nativeQuery = true)
    public List<PelangganModels> getPelanggan(@Param("cariParam") String cari);
}
