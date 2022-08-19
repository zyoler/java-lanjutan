package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObatRepository extends JpaRepository<ObatModels, Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM ObatModels u WHERE u.id_obat=:id_obat")
    public ObatModels getObatById(Integer id_obat);

    @Query("SELECT u FROM ObatModels u WHERE u.nama_pemasok=:nama_pemasok")
    public List<ObatModels> getObatByNamaPemasok(String nama_pemasok);

    @Query("SELECT u FROM ObatModels u WHERE u.nama_obat=:nama_obat")
    public List<ObatModels> getObatByNama(String nama_obat);

    @Query("SELECT u FROM ObatModels u WHERE u.nama_obat=:nama_obat")
    public List<ObatModels> getObatByNamaObat(String nama_obat);

    @Query("FROM ObatModels")
    public List<ObatModels> getObats();

    @Query(value = "select * from table_med", nativeQuery = true)
    public List<ObatModels> getObatsNative();

    @Query(value = "SELECT * FROM table_med WHERE kedaluwarsa BETWEEN DATE_SUB(NOW(), INTERVAL 40 YEAR) AND NOW()", nativeQuery = true)
    public List<ObatModels> getObatExpNative();

    @Query(value = "SELECT count(id_obat) FROM table_med WHERE kedaluwarsa BETWEEN DATE_SUB(NOW(), INTERVAL 40 YEAR) AND NOW()", nativeQuery = true)
    public Integer getObatCountExpNative();

    @Query(value = "SELECT sum(stok) FROM table_med", nativeQuery = true)
    public Integer getObatSumNative();

    @Query(value = "SELECT * FROM table_med WHERE kedaluwarsa BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 60 DAY)", nativeQuery = true)
    public List<ObatModels> getObatAlmostExpNative();

    @Query(value = "SELECT * FROM table_med WHERE stok BETWEEN 0 AND 0", nativeQuery = true)
    public List<ObatModels> getObatOutStokNative();

    @Query(value = "SELECT count(id_obat) FROM table_med WHERE stok BETWEEN 0 AND 0", nativeQuery = true)
    public Integer getObatCountOutStokNative();

    @Query(value = "SELECT * FROM table_med WHERE stok BETWEEN 1 AND 8", nativeQuery = true)
    public List<ObatModels> getObatAlmostOutStokNative();

}
