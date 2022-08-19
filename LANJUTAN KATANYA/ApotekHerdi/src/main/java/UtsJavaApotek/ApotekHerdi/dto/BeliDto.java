package UtsJavaApotek.ApotekHerdi.dto;

public class BeliDto {
    Integer id_pembelian;
    String ref;
    String nama_obat;
    Integer harga_beli;
    Integer banyak;
    Integer subtotal;
    String nama_pemasok;
    String tgl_beli;
    Integer grandtotal;

    public Integer getId_pembelian() {
        return id_pembelian;
    }

    public void setId_pembelian(Integer id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public Integer getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(Integer harga_beli) {
        this.harga_beli = harga_beli;
    }

    public Integer getBanyak() {
        return banyak;
    }

    public void setBanyak(Integer banyak) {
        this.banyak = banyak;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public String getNama_pemasok() {
        return nama_pemasok;
    }

    public void setNama_pemasok(String nama_pemasok) {
        this.nama_pemasok = nama_pemasok;
    }

    public String getTgl_beli() {
        return tgl_beli;
    }

    public void setTgl_beli(String tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

    public Integer getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(Integer grandtotal) {
        this.grandtotal = grandtotal;
    }
}
