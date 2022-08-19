package com.example.demo.repositories;

import com.example.demo.models.Member;
import com.example.demo.models.Supir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupirRepository extends JpaRepository<Supir, Integer> {
    @Query("FROM Supir")
    public List<Supir> getSupir();

    @Query(value = "select * from supir where id_supir like %:cariParam% or nama_supir like %:cariParam% or alamat like %:cariParam% or no_telp like %:cariParam% or harga_perhari like %:cariParam% or status like %:cariParam% ", nativeQuery = true)
    public List<Supir> getSupir(@Param("cariParam")String cari);
}
