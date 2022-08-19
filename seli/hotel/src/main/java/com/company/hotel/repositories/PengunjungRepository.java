package com.company.hotel.repositories;

import com.company.hotel.model.Pengunjung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PengunjungRepository extends JpaRepository<Pengunjung,Integer> {
    @Query("FROM Pengunjung")
    public List<Pengunjung> getPengunjung();


    @Query(value = "select * from pengunjung where id LIKE %:cariParam% or no_ktp LIKE %:cariParam% or nama_pengunjung LIKE %:cariParam% or jenis_kelamin LIKE %:cariParam% or alamat LIKE %:cariParam% or email LIKE %:cariParam% or no_hp LIKE %:cariParam%",nativeQuery = true)
    public List<Pengunjung> getPengunjung(@Param("cariParam") String cari);
}
