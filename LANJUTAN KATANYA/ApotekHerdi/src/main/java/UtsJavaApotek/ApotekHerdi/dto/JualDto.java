package UtsJavaApotek.ApotekHerdi.dto;

public class JualDto {
    Integer id_tagihan;
    String ref;
    String nama_obat;
    Integer harga_jual;
    Integer banyak;
    Integer subtotal;
    String nama_pembeli;
    String tgl_beli;
    Integer grandtotal;

    public Integer getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(Integer id_tagihan) {
        this.id_tagihan = id_tagihan;
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

    public Integer getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Integer harga_jual) {
        this.harga_jual = harga_jual;
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

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
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
