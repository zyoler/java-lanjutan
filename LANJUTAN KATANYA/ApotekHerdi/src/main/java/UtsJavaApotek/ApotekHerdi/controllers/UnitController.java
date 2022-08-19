package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.UnitDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.UnitRepository;
import UtsJavaApotek.ApotekHerdi.services.UnitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UnitController {
    @Autowired
    UnitRepository unitrepo;

    @Autowired
    UnitServices unitservice;

    @Autowired
    ObatRepository obatrepo;

    @GetMapping("/dataunit")
    public String dataUnit(Model model){

        List<UnitModels> unit = unitrepo.getUnits();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("unit", unit);
        model.addAttribute("title","Data Unit");
        return "dataunit";
    }

    @RequestMapping(value = "/doInsertUnit", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        UnitDto dto = new UnitDto();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("unitDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertUnit";
    }

    @RequestMapping(value = "/saveUnit", method = RequestMethod.POST)
    public String saveData(UnitDto unitDto, ModelMap model) throws Exception{
        UnitModels result = unitservice.saveUnit(unitDto);
        System.out.println("=================="+result.getId_unit());
        return "redirect:dataunit";
    }

    @GetMapping("/deleteDataUnit")
    public String delete(int id_unit){
        unitservice.deleteUnit(id_unit);
        return "redirect:dataunit";
    }

    @RequestMapping(value = "/doUpdateDataUnit", method = RequestMethod.GET)
    public String doUpdateDataUnit(ModelMap model, int id_unit) throws Exception{
        UnitDto dto = unitservice.getUnitById(id_unit);

        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("unit", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateUnit";

    }

    @RequestMapping(value = "/updateUnit", method = RequestMethod.POST)
    public String updateUnit(UnitDto unitDto) throws Exception{
        UnitModels result = unitservice.updateUnit(unitDto);
        System.out.println("UPDATE =================="+result.getId_unit());
        return "redirect:dataunit";
    }
}
