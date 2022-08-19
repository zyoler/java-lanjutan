package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.dto.RestDto;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.services.ObatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatServiceImpl implements ObatServices {
    @Autowired
    ObatRepository obatrepo;

    @Override
    public boolean deleteObat(int id) {
        ObatModels model = obatrepo.getObatById(id);
        obatrepo.delete(model);
        return true;
    }

    @Override
    public ObatModels saveObat(ObatDto obat) {
        ObatModels model = new ObatModels();
        ObatModels result = new ObatModels();
        try {
            model.setNama_obat(obat.getNama_obat());
            model.setPenyimpanan(obat.getPenyimpanan());
            model.setStok(obat.getStok());
            model.setUnit(obat.getUnit());
            model.setNama_kategori(obat.getNama_kategori());
            model.setKedaluwarsa(obat.getKedaluwarsa().toString());
            model.setDes_obat(obat.getDes_obat());
            model.setHarga_beli(obat.getHarga_beli());
            model.setHarga_jual(obat.getHarga_jual());
            model.setNama_pemasok(obat.getNama_pemasok());
            result = obatrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<ObatModels> getObatsNative() {
        return obatrepo.getObatsNative();
    }

    @Override
    public ObatDto getObatById(int kdobat) {
        ObatModels model = obatrepo.getObatById(kdobat);
        ObatDto dto = new ObatDto();
        dto.setId_obat(kdobat);
        dto.setNama_obat(model.getNama_obat());
        dto.setPenyimpanan(model.getPenyimpanan());
        dto.setStok(model.getStok());
        dto.setUnit(model.getUnit());
        dto.setNama_kategori(model.getNama_kategori());
        dto.setKedaluwarsa(model.getKedaluwarsa());
        dto.setDes_obat(model.getDes_obat());
        dto.setHarga_beli(model.getHarga_beli());
        dto.setHarga_jual(model.getHarga_jual());
        dto.setNama_pemasok(model.getNama_pemasok());
        return dto;
    }

    @Override
    public RestDto getObatByNama(String nama_obat) {
        ObatModels model = (ObatModels) obatrepo.getObatByNamaObat(nama_obat);
        RestDto dto = new RestDto();
        dto.setNama_obat(model.getNama_obat());
        dto.setHarga_jual(model.getHarga_jual());
        dto.setNama_pemasok(model.getNama_pemasok());
        return dto;
    }


    @Override
    public ObatModels updateObat(ObatDto obat) {
        ObatModels model = new ObatModels();
        ObatModels result = new ObatModels();
        try {
            model.setId_obat(obat.getId_obat());
            model.setNama_obat(obat.getNama_obat());
            model.setPenyimpanan(obat.getPenyimpanan());
            model.setStok(obat.getStok());
            model.setUnit(obat.getUnit());
            model.setNama_kategori(obat.getNama_kategori());
            model.setKedaluwarsa(obat.getKedaluwarsa().toString());
            model.setDes_obat(obat.getDes_obat());
            model.setHarga_beli(obat.getHarga_beli());
            model.setHarga_jual(obat.getHarga_jual());
            model.setNama_pemasok(obat.getNama_pemasok());
            result = obatrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
