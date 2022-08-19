package com.example.demo.repositories;

import com.example.demo.models.Mobil;
import com.example.demo.models.Paket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaketRepository extends JpaRepository<Paket, Integer> {
    @Query("FROM Paket")
    public List<Paket> getPaket();

    @Query(value = "select * from paket where id_paket like %:cariParam% or nama_paket like %:cariParam% or diskon like %:cariParam% or lama_rental like %:cariParam%", nativeQuery = true)
    public List<Paket> getPaket(@Param("cariParam")String cari);

}
