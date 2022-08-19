package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.dto.RestDto;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;

import java.util.List;

public interface ObatServices {
    public boolean deleteObat(int id);
    public ObatModels saveObat(ObatDto obat);
    public List<ObatModels> getObatsNative();
    public ObatDto getObatById(int kdobat);
    public RestDto getObatByNama(String nama_obat);
    public ObatModels updateObat(ObatDto obat);
}
