package org.pubpasim.mudik.repository;

import org.pubpasim.mudik.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AkunRepository extends JpaRepository<Akun, String> {

    @Query("SELECT u FROM Akun u WHERE u.id = ?1 OR u.namaPengguna = ?1")
    Optional<Akun> findById(String id);

    @Query("SELECT u FROM Akun u ORDER BY u.angkatan.nomor, u.nama")
    List<Akun> findAll();

}