package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.JualDto;
import UtsJavaApotek.ApotekHerdi.models.JualModels;
import UtsJavaApotek.ApotekHerdi.repositories.JualRepository;
import UtsJavaApotek.ApotekHerdi.services.JualServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JualServiceImpl implements JualServices {

    @Autowired
    JualRepository jualrepo;

    @Override
    public boolean deleteJual(int id) {
        JualModels model = jualrepo.getJualById(id);
        jualrepo.delete(model);
        return true;
    }

    @Override
    public JualModels saveJual(JualDto jual) {
        JualModels model = new JualModels();
        JualModels result = new JualModels();
        try {
            model.setRef(jual.getRef());
            model.setNama_obat(jual.getNama_obat());
            model.setHarga_jual(jual.getHarga_jual());
            model.setBanyak(jual.getBanyak());
            model.setSubtotal(jual.getSubtotal());
            model.setNama_pembeli(jual.getNama_pembeli());
            model.setTgl_beli(jual.getTgl_beli());
            model.setGrandtotal(jual.getGrandtotal());
            result = jualrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public JualModels saveJualByArray(String nama_pembeli, String ref, String tgl_beli, String nama_obat, Integer harga_jual, Integer banyak, Integer subtotal, Integer grandtotal) {
        JualModels model = new JualModels();
        JualModels result = new JualModels();
        try {
                model.setRef(ref);
                model.setNama_obat(nama_obat);
                model.setHarga_jual(harga_jual);
                model.setBanyak(banyak);
                model.setSubtotal(subtotal);
                model.setNama_pembeli(nama_pembeli);
                model.setTgl_beli(tgl_beli);
                model.setGrandtotal(grandtotal);
                result = jualrepo.save(model);
        }catch (Exception e){

        }

        return result;
    }

    @Override
    public List<JualModels> getJualNative() {
        return jualrepo.getJualNative();
    }

    @Override
    public JualDto getJualById(int id_tagihan) {
        JualModels model = jualrepo.getJualById(id_tagihan);
        JualDto dto = new JualDto();
        dto.setId_tagihan(id_tagihan);
        dto.setRef(model.getRef());
        dto.setNama_obat(model.getNama_obat());
        dto.setHarga_jual(model.getHarga_jual());
        dto.setBanyak(model.getBanyak());
        dto.setSubtotal(model.getSubtotal());
        dto.setNama_pembeli(model.getNama_pembeli());
        dto.setTgl_beli(model.getTgl_beli());
        dto.setGrandtotal(model.getGrandtotal());
        return dto;
    }

    @Override
    public List<Object> getCharts(String tahun) {
        return jualrepo.getChart(tahun);
    }
}
