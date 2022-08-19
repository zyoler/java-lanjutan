package org.neophyte.pertemuan1.Repositories;

import org.neophyte.pertemuan1.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
    @Query("FROM Mahasiswa")
    public List<Mahasiswa> getMahasiswa();

    @Query(value = "select * from mahasiswa where id LIKE %:cariParam% or nim LIKE %:cariParam% or nama LIKE %:cariParam% or alamat LIKE %:cariParam%",nativeQuery = true)
    public List<Mahasiswa> getMahasiswa(@Param("cariParam") String cari);
}
