package UtsJavaApotek.ApotekHerdi.services;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.UnitDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;

import java.util.List;

public interface UnitServices {
    public boolean deleteUnit(int id);
    public UnitModels saveUnit(UnitDto unit);
    public List<UnitModels> getUnitsNative();
    public UnitDto getUnitById(int id_unit);
    public UnitModels updateUnit(UnitDto unit);
}
