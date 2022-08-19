package com.example.demo.Repositories;

import com.example.demo.Model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
    @Query("FROM Mahasiswa")
    public List<Mahasiswa> getMahasiswa();

    @Query(value = "select * from Mahasiswa where id like %:cariParam% or nama like %:cariParam% or alamat like %:cariParam% or jk like %:cariParam% or jurusan like %:cariParam% or telp like %:cariParam% or email like %:cariParam%", nativeQuery = true)
    public List<Mahasiswa> getMahasiswa(@Param("cariParam") String cari);
}
