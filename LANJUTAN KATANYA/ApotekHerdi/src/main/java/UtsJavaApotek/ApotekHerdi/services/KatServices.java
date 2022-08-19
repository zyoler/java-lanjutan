package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;

import java.util.List;

public interface KatServices {
    public boolean deleteKat(int id);
    public KatModels saveKat(KatDto kat);
    public List<KatModels> getKatsNative();
    public KatDto getKatById(int id_kat);
    public KatModels updateKat(KatDto kat);
}
