package com.example.demo.repositories;

import com.example.demo.models.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
    @Query("FROM Mahasiswa")
    public List<Mahasiswa> getMahasiswa();

    @Query(value = "select * from mahasiswa where nim like %:cariParam% or nama like %:cariParam% or jk like %:cariParam% or jurusan like %:cariParam% or nohp like %:cariParam% or email like %:cariParam% or alamat like %:cariParam%", nativeQuery = true)
    public List<Mahasiswa> getMahasiswa(@Param("cariParam") String cari);
}
