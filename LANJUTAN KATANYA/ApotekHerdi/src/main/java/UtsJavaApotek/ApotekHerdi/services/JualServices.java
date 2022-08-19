package UtsJavaApotek.ApotekHerdi.services;



import UtsJavaApotek.ApotekHerdi.dto.JualDto;
import UtsJavaApotek.ApotekHerdi.models.JualModels;

import java.util.List;

public interface JualServices {
    public boolean deleteJual(int id);
    public JualModels saveJual(JualDto jual);
    public JualModels saveJualByArray(String nama_pembeli, String ref, String tgl_beli, String nama_obat, Integer harga_jual, Integer banyak,
                                      Integer subtotal, Integer grandtotal);
    public List<JualModels> getJualNative();
    public JualDto getJualById(int id_tagihan);
    public List<Object> getCharts(String tahun);
}
