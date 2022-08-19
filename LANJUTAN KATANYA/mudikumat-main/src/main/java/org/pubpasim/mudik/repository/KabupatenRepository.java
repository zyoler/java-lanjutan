package org.pubpasim.mudik.repository;

import org.pubpasim.mudik.model.Kabupaten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KabupatenRepository extends JpaRepository<Kabupaten, Long> {

    @Query("SELECT u AS jumlahPemudik FROM Kabupaten u WHERE u.mudik.size > 0")
    List<Kabupaten> findKabupatenMudik();

}