package UtsJavaApotek.ApotekHerdi.services.Imple;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.UnitDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;
import UtsJavaApotek.ApotekHerdi.repositories.UnitRepository;
import UtsJavaApotek.ApotekHerdi.services.UnitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitServices {
    @Autowired
    UnitRepository unitrepo;
    @Override
    public boolean deleteUnit(int id) {
        UnitModels model = unitrepo.getUnitById(id);
        unitrepo.delete(model);
        return true;
    }

    @Override
    public UnitModels saveUnit(UnitDto unit) {
        UnitModels model = new UnitModels();
        UnitModels result = new UnitModels();
        try {
            model.setUnit(unit.getUnit());
            result = unitrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<UnitModels> getUnitsNative() {
        return unitrepo.getUnitNative();
    }

    @Override
    public UnitDto getUnitById(int id_unit) {
        UnitModels model = unitrepo.getUnitById(id_unit);
        UnitDto dto = new UnitDto();
        dto.setId_unit(id_unit);
        dto.setUnit(model.getUnit());
        return dto;
    }

    @Override
    public UnitModels updateUnit(UnitDto unit) {
        UnitModels model = new UnitModels();
        UnitModels result = new UnitModels();
        try {
            model.setId_unit(unit.getId_unit());
            model.setUnit(unit.getUnit());
            result = unitrepo.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
