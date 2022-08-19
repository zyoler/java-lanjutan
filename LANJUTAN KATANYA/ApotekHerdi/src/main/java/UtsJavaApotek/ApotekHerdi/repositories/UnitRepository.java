package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<UnitModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM UnitModels u WHERE u.id_unit=:id_unit")
    public UnitModels getUnitById(Integer id_unit);

    @Query("FROM UnitModels")
    public List<UnitModels> getUnits();

    @Query(value = "select * from table_unit", nativeQuery = true)
    public List<UnitModels> getUnitNative();

    @Query(value = "select count(id_unit) from table_unit", nativeQuery = true)
    public Integer getCountUnitNative();

    @Query(value = "SELECT unit, SUM(stok) AS stok FROM table_med GROUP BY unit", nativeQuery = true)
    public List<Object> getChartUnitNative();
}
