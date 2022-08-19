package UtsJavaApotek.ApotekHerdi.services;


import UtsJavaApotek.ApotekHerdi.dto.SuppDto;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;

import java.util.List;

public interface SuppServices {
    public boolean deleteSupp(int id);
    public SuppModels saveSupp(SuppDto supp);
    public List<SuppModels> getSuppNative();
    public SuppDto getSuppById(int id_pemasok);
    public SuppModels updateSupp(SuppDto supp);
}
