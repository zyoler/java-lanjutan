package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeliRepository extends JpaRepository<BeliModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM BeliModels u WHERE u.id_pembelian=:id_pembelian")
    public BeliModels getBeliById(Integer id_pembelian);

    @Query(value = "select * from table_purchase where ref=:ref GROUP BY nama_obat ORDER by tgl_beli ASC", nativeQuery = true)
    public List<BeliModels> getBeliByRef(String ref);

    @Query(value = "select *,sum(banyak) as totbanyak from table_purchase where ref=:ref GROUP BY ref ORDER by tgl_beli ASC", nativeQuery = true)
    public Object getBeliByReff(String ref);

    @Query("FROM BeliModels")
    public List<BeliModels> getBeli();

    @Query(value = "select * from table_purchase", nativeQuery = true)
    public List<BeliModels> getBeliNative();

    @Query(value="SELECT sum(subtotal) FROM table_purchase", nativeQuery=true)
    public Integer jumlahbeli();

    @Query(value="SELECT month.month_name as month, SUM(table_purchase.subtotal) AS total \n" +
            "            FROM month \n" +
            "            LEFT JOIN table_purchase ON (month.month_num = MONTH(table_purchase.tgl_beli)  \n" +
            "            AND YEAR(table_purchase.tgl_beli)=:tahun_beli)\n" +
            "        GROUP BY month.month_name ORDER BY month.month_num", nativeQuery=true)
    public List<Object> getPurchaseChart(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_purchase.subtotal) as 'totEarned' FROM table_med \n" +
            "               INNER JOIN table_purchase ON table_med.nama_obat=table_purchase.nama_obat\n" +
            "                AND YEAR(table_purchase.tgl_beli)=:tahun_beli\n" +
            "               GROUP BY table_purchase.nama_obat \n" +
            "               ORDER BY totEarned ASC", nativeQuery=true)
    public List<Object> getlowestPurchase(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_purchase.subtotal) as 'totEarned' FROM table_med \n" +
            "                INNER JOIN table_purchase ON table_med.nama_obat=table_purchase.nama_obat\n" +
            "                 AND YEAR(table_purchase.tgl_beli)=:tahun_beli \n" +
            "                GROUP BY table_purchase.nama_obat \n" +
            "                ORDER BY totEarned DESC", nativeQuery=true)
    public List<Object> getHighestPurchase(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_purchase.banyak) as 'totSold' FROM table_med \n" +
            "                INNER JOIN table_purchase ON table_med.nama_obat=table_purchase.nama_obat \n" +
            "                 AND YEAR(table_purchase.tgl_beli)=:tahun_beli\n" +
            "                GROUP BY table_purchase.nama_obat ORDER BY totSold ASC", nativeQuery=true)
    public List<Object> leastPurchase(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_purchase.banyak) as 'totSold' FROM table_med \n" +
            "                INNER JOIN table_purchase ON table_med.nama_obat=table_purchase.nama_obat\n" +
            "                AND YEAR(table_purchase.tgl_beli)=:tahun_beli\n" +
            "                GROUP BY table_purchase.nama_obat ORDER BY totSold DESC", nativeQuery=true)
    public List<Object> topPurchase(String tahun_beli);
}
