package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppRepository extends JpaRepository<SuppModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM SuppModels u WHERE u.id_pem=:id_pem")
    public SuppModels getSuppById(Integer id_pem);

    @Query("FROM SuppModels")
    public List<SuppModels> getSupps();

    @Query(value = "select * from table_sup", nativeQuery = true)
    public List<SuppModels> getSuppNative();

    @Query(value = "select count(id_pem) from table_sup", nativeQuery = true)
    public Integer getCountSuppNative();
}
