package com.example.demo.repositories;

import com.example.demo.models.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MobilRepository extends JpaRepository<Mobil, Integer> {
    @Query("FROM Mobil")
    public List<Mobil> getMobil();

    @Query(value = "select * from mobil where id_mobil like %:cariParam% or nama_mobil like %:cariParam% or merk like %:cariParam% or warna like %:cariParam% or tahun like %:cariParam% or seri_kota like %:cariParam% or no_polisi like %:cariParam% or huruf like %:cariParam% or status like %:cariParam% or harga like %:cariParam%", nativeQuery = true)
    public List<Mobil> getMobil(@Param("cariParam")String cari);
}
