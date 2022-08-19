package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.repositories.KatRepository;
import UtsJavaApotek.ApotekHerdi.services.KatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KatServiceImpl implements KatServices {
    @Autowired
    KatRepository katrepo;

    @Override
    public boolean deleteKat(int id) {
        KatModels model = katrepo.getKatById(id);
        katrepo.delete(model);
        return true;
    }

    @Override
    public KatModels saveKat(KatDto kat) {
        KatModels model = new KatModels();
        KatModels result = new KatModels();
        try {
            model.setNama_kategori(kat.getNama_kategori());
            model.setDes_kat(kat.getDes_kat());
            result = katrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<KatModels> getKatsNative() {
        return katrepo.getKatNative();
    }

    @Override
    public KatDto getKatById(int id_kat) {
        KatModels model = katrepo.getKatById(id_kat);
        KatDto dto = new KatDto();
        dto.setId_kat(id_kat);
        dto.setNama_kategori(model.getNama_kategori());
        dto.setDes_kat(model.getDes_kat());
        return dto;
    }

    @Override
    public KatModels updateKat(KatDto kat) {
        KatModels model = new KatModels();
        KatModels result = new KatModels();
        try {
            model.setId_kat(kat.getId_kat());
            model.setNama_kategori(kat.getNama_kategori());
            model.setDes_kat(kat.getDes_kat());
            result = katrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
