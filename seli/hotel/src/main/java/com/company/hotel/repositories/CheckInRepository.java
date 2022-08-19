package com.company.hotel.repositories;

import com.company.hotel.model.CheckIn;
import com.company.hotel.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CheckInRepository extends JpaRepository<CheckIn,Integer> {
    @Query("FROM CheckIn ")
    public List<CheckIn> getCheckIn();

    @Query(value = "select * from Check_in where id LIKE %:cariParam% or tipe_kamar LIKE %:cariParam% or fasilitas LIKE %:cariParam% or nama_karyawan LIKE %:cariParam% or nama_pengunjung LIKE %:cariParam% or lama_menginap LIKE %:cariParam%",nativeQuery = true)
    public List<CheckIn> getCheckIn(@Param("cariParam") String cari);
}
