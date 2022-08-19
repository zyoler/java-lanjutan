package com.company.hotel.repositories;

import com.company.hotel.model.Admin;
import com.company.hotel.model.Kamar;
import com.company.hotel.model.Pengunjung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KamarRepository extends JpaRepository<Kamar,Integer> {
    @Query("FROM Kamar")
    public List<Kamar> getKamar();

    @Query(value = "select * from kamar where id LIKE %:cariParam% or tipe_kamar LIKE %:cariParam% or fasilitas LIKE %:cariParam% or harga LIKE %:cariParam% or kapasitas LIKE %:cariParam% or status LIKE %:cariParam%",nativeQuery = true)
    public List<Kamar> getKamar(@Param("cariParam") String cari);
}
