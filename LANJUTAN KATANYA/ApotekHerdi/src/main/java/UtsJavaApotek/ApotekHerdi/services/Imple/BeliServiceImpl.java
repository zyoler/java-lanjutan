package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.BeliDto;
import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import UtsJavaApotek.ApotekHerdi.models.JualModels;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.repositories.BeliRepository;
import UtsJavaApotek.ApotekHerdi.services.BeliServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeliServiceImpl implements BeliServices {

    @Autowired
    BeliRepository belirepo;
    @Override
    public boolean deleteBeli(int id) {
        BeliModels model = belirepo.getBeliById(id);
        belirepo.delete(model);
        return true;
    }

    @Override
    public BeliModels saveBeli(BeliDto beli) {
        BeliModels model = new BeliModels();
        BeliModels result = new BeliModels();
        System.out.println(beli.getNama_obat());
        try {
            model.setRef(beli.getRef());
            model.setNama_obat(beli.getNama_obat());
            model.setHarga_beli(beli.getHarga_beli());
            model.setBanyak(beli.getBanyak());
            model.setSubtotal(beli.getSubtotal());
            model.setNama_pemasok(beli.getNama_pemasok());
            model.setTgl_beli(beli.getTgl_beli());
            model.setGrandtotal(beli.getGrandtotal());
            result = belirepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<BeliModels> getBeliNative() {
        return belirepo.getBeliNative();
    }

    @Override
    public BeliDto getBeliById(int id_pembelian) {
        BeliModels model = belirepo.getBeliById(id_pembelian);
        BeliDto dto = new BeliDto();
        dto.setId_pembelian(id_pembelian);
        dto.setRef(model.getRef());
        dto.setNama_obat(model.getNama_obat());
        dto.setHarga_beli(model.getHarga_beli());
        dto.setBanyak(model.getBanyak());
        dto.setSubtotal(model.getSubtotal());
        dto.setNama_pemasok(model.getNama_pemasok());
        dto.setTgl_beli(model.getTgl_beli());
        dto.setGrandtotal(model.getGrandtotal());
        return dto;
    }
}
