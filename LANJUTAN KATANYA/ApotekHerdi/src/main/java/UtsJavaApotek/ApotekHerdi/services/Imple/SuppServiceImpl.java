package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.SuppDto;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.repositories.SuppRepository;
import UtsJavaApotek.ApotekHerdi.services.SuppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppServiceImpl implements SuppServices {
    @Autowired
    SuppRepository supprepo;

    @Override
    public boolean deleteSupp(int id) {
        SuppModels model = supprepo.getOne(id);
        supprepo.delete(model);
        return true;
    }

    @Override
    public SuppModels saveSupp(SuppDto supp) {
        SuppModels model = new SuppModels();
        SuppModels result = new SuppModels();
        try {
            model.setNama_pemasok(supp.getNama_pemasok());
            model.setAlamat(supp.getAlamat());
            model.setTelepon(supp.getTelepon());
            result = supprepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<SuppModels> getSuppNative() {
        return supprepo.getSuppNative();
    }

    @Override
    public SuppDto getSuppById(int id_pemasok) {
        SuppModels model = supprepo.getSuppById(id_pemasok);
        SuppDto dto = new SuppDto();
        dto.setId_pem(id_pemasok);
        dto.setNama_pemasok(model.getNama_pemasok());
        dto.setAlamat(model.getAlamat());
        dto.setTelepon(model.getTelepon());
        return dto;
    }

    @Override
    public SuppModels updateSupp(SuppDto supp) {
        SuppModels model = new SuppModels();
        SuppModels result = new SuppModels();
        try {
            model.setId_pem(supp.getId_pem());
            model.setNama_pemasok(supp.getNama_pemasok());
            model.setAlamat(supp.getAlamat());
            model.setTelepon(supp.getTelepon());
            result = supprepo.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
