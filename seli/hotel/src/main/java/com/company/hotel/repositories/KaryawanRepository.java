package com.company.hotel.repositories;

import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan,Integer> {
    @Query("FROM Karyawan ")
    public List<Karyawan> getKaryawan();


    @Query(value = "select * from karyawan where id LIKE %:cariParam% or no_ktp LIKE %:cariParam% or nama_karyawan LIKE %:cariParam% or jenis_kelamin LIKE %:cariParam% or alamat LIKE %:cariParam% or email LIKE %:cariParam% or no_telp LIKE %:cariParam%",nativeQuery = true)
    public List<Karyawan> getKaryawan(@Param("cariParam") String cari);

}
