package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.KatModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KatRepository extends JpaRepository<KatModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM KatModels u WHERE u.id_kat=:id_kat")
    public KatModels getKatById(Integer id_kat);

    @Query("FROM KatModels")
    public List<KatModels> getKats();

    @Query(value = "select * from table_cat", nativeQuery = true)
    public List<KatModels> getKatNative();

    @Query(value = "select count(id_kat) from table_cat", nativeQuery = true)
    public Integer getCountKatNative();
}
