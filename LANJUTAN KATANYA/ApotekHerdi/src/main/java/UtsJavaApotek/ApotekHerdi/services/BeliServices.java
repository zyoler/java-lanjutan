package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.BeliDto;
import UtsJavaApotek.ApotekHerdi.models.BeliModels;


import java.util.List;

public interface BeliServices {
    public boolean deleteBeli(int id);
    public BeliModels saveBeli(BeliDto beli);
    public List<BeliModels> getBeliNative();
    public BeliDto getBeliById(int id_pembelian);
}
