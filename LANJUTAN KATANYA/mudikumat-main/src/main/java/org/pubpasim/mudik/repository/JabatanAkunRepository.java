package org.pubpasim.mudik.repository;

import org.pubpasim.mudik.model.JabatanAkun;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JabatanAkunRepository extends JpaRepository<JabatanAkun, Long> {

    @Query("SELECT u FROM JabatanAkun u WHERE u.akun.id = ?1 AND (u.akhirMenjabat > ?2 OR u.akhirMenjabat IS NULL) ORDER BY u.jabatan.id")
    List<JabatanAkun> findByAkunId(String id, int periode, PageRequest pageRequest);

}