package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import UtsJavaApotek.ApotekHerdi.models.JualModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JualRepository extends JpaRepository<JualModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM JualModels u WHERE u.id_tagihan=:id_tagihan")
    public JualModels getJualById(Integer id_tagihan);

    @Query(value = "select * from table_invoice where ref=:ref GROUP BY nama_obat ORDER by tgl_beli ASC", nativeQuery = true)
    public List<JualModels> getJualByRef(String ref);

    @Query(value = "select *,sum(banyak) as totbanyak from table_invoice where ref=:ref GROUP BY ref ORDER by tgl_beli ASC", nativeQuery = true)
    public Object getJualByReff(String ref);

    @Query("FROM JualModels")
    public List<JualModels> getJual();

    @Query(value = "SELECT id_tagihan,ref, nama_obat,harga_jual,SUM(banyak) as banyak,subtotal,nama_pembeli, tgl_beli, grandtotal FROM table_invoice GROUP BY ref ORDER BY tgl_beli ASC", nativeQuery = true)
    public List<JualModels> getJualNative();

    @Query(value="SELECT sum(subtotal) FROM table_invoice", nativeQuery=true)
    public Integer jumlahjual();

    @Query(value = "SELECT m.month_name as month, \n" +
            "                   i.total_inv, \n" +
            "                   p.total_pur\n" +
            "                FROM month m\n" +
            "                LEFT JOIN (SELECT MONTH(tgl_beli) as month, \n" +
            "                            SUM(subtotal) as total_inv  \n" +
            "                            FROM table_invoice\n" +
            "                            WHERE YEAR(tgl_beli)=:tahun_beli\n" +
            "                            GROUP BY month) i  ON (m.month_num = i.month)    \n" +
            "                LEFT JOIN (SELECT MONTH(tgl_beli) as month, \n" +
            "                            SUM(subtotal) as total_pur\n" +
            "                            FROM  table_purchase \n" +
            "                            WHERE YEAR(tgl_beli)=:tahun_beli\n" +
            "                            GROUP BY month) p ON (m.month_num = p.month )\n" +
            "                ORDER BY m.month_num", nativeQuery = true)
    public List<Object> getChart(String tahun_beli);

    @Query(value="SELECT month.month_name as month, SUM(table_invoice.subtotal) AS total \n" +
                "FROM month LEFT JOIN table_invoice ON (month.month_num = MONTH(table_invoice.tgl_beli)" +
                "AND YEAR(table_invoice.tgl_beli)=:tahun_beli)\n" +
                "GROUP BY month.month_name  ORDER BY month.month_num ", nativeQuery=true)
    public List<Object> getInvoiceChart(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_invoice.subtotal) as 'totEarned' FROM table_med \n" +
            "               INNER JOIN table_invoice ON table_med.nama_obat=table_invoice.nama_obat\n" +
            "               AND YEAR(table_invoice.tgl_beli)=:tahun_beli \n" +
            "               GROUP BY table_invoice.nama_obat \n" +
            "               ORDER BY totEarned ASC", nativeQuery=true)
    public List<Object> getlowestInvoice(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_invoice.subtotal) as 'totEarned' FROM table_med \n" +
            "                INNER JOIN table_invoice ON table_med.nama_obat=table_invoice.nama_obat\n" +
            "                AND YEAR(table_invoice.tgl_beli)=:tahun_beli \n" +
            "                GROUP BY table_invoice.nama_obat \n" +
            "                ORDER BY totEarned DESC", nativeQuery=true)
    public List<Object> getHighestInvoice(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_invoice.banyak) as 'totSold' FROM table_med \n" +
            "                INNER JOIN table_invoice ON table_med.nama_obat=table_invoice.nama_obat" +
            " AND YEAR(table_invoice.tgl_beli)=:tahun_beli GROUP BY table_invoice.nama_obat ORDER BY totSold ASC", nativeQuery=true)
    public List<Object> leastInvoice(String tahun_beli);

    @Query(value="SELECT table_med.nama_obat, SUM(table_invoice.banyak) as 'totSold' FROM table_med \n" +
            "                INNER JOIN table_invoice ON table_med.nama_obat=table_invoice.nama_obat " +
            "AND YEAR(table_invoice.tgl_beli)=:tahun_beli GROUP BY table_invoice.nama_obat ORDER BY totSold DESC", nativeQuery=true)
    public List<Object> topInvoice(String tahun_beli);


}
