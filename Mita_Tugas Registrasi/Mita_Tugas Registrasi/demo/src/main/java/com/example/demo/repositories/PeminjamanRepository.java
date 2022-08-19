package com.example.demo.repositories;

import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Integer> {
    @Query("FROM Peminjaman")
    public List<Peminjaman> getPeminjaman();

    @Query("FROM Member")
    public List<Member> getMember();

    @Query("FROM Mobil")
    public List<Mobil> getMobil();

    @Query("FROM Supir")
    public List<Supir> getSupir();

    @Query("FROM Paket")
    public List<Paket> getPaket();

    @Query(value = "select * FROM Member where :cariParam",nativeQuery = true)
    public Member getMemberById(@Param("cariParam")Integer cari);

    @Query(value = "select * from peminjaman where id_peminjaman like %cariParam% or id_member like %cariParam% or tgl_peminjaman like %cariParam% or tgl_kembali like %cariParam% or total like %cariParam% or uang_muka like %cariParam% or diskon like %cariParam% or denda like %cariParam% or lama like %cariParam% or status like %cariParam%",nativeQuery = true)
    public List<Peminjaman> getPeminjaman(@Param("cariParam")String cari);

}
