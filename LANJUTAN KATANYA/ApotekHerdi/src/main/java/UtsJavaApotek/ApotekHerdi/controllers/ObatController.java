package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;
import UtsJavaApotek.ApotekHerdi.repositories.KatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.SuppRepository;
import UtsJavaApotek.ApotekHerdi.repositories.UnitRepository;
import UtsJavaApotek.ApotekHerdi.services.Imple.ObatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ObatController {
    @Autowired
    ObatRepository obatrepo;

    @Autowired
    KatRepository katrepo;

    @Autowired
    SuppRepository suprepo;

    @Autowired
    UnitRepository unitrepo;

    @Autowired
    ObatServiceImpl obatservices;

    @GetMapping("/dataobat")
    public String dataobat(Model model){

        List<ObatModels> obats = obatrepo.getObats();
        Integer countobatexp = obatrepo.getObatCountExpNative();
        Integer countobatstok = obatrepo.getObatCountOutStokNative();
        model.addAttribute("obats", obats);
        model.addAttribute("countexp", countobatexp);
        model.addAttribute("countstok", countobatstok);
        model.addAttribute("title","Data Obat");
        return "dataobat";
    }

    @GetMapping("/dataobatexp")
    public String dataobatexp(Model model){

        List<ObatModels> obatexp = obatrepo.getObatExpNative();
        List<ObatModels> obatalmexp = obatrepo.getObatAlmostExpNative();
        Integer countexp = obatrepo.getObatCountExpNative();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("obatexp", obatexp);
        model.addAttribute("obatalmexp", obatalmexp);
        model.addAttribute("countexp", countexp);
        model.addAttribute("title","Data Obat Kedaluwarsa");
        return "dataobatexp";
    }

    @GetMapping("/dataobatoutstok")
    public String dataobatoutstok(Model model){

        List<ObatModels> obatout = obatrepo.getObatOutStokNative();
        List<ObatModels> obatalmout= obatrepo.getObatAlmostOutStokNative();
        Integer countstok = obatrepo.getObatCountOutStokNative();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("obatout", obatout);
        model.addAttribute("obatalmout", obatalmout);
        model.addAttribute("countstok", countstok);
        model.addAttribute("title","Data tok Obat Habis");
        return "dataobatoutstok";
    }


    @RequestMapping(value = "/doInsertObat", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        ObatDto dto = new ObatDto();
        List<KatModels> kat = katrepo.getKats();
        List<SuppModels> supp = suprepo.getSupps();
        List<UnitModels> unit = unitrepo.getUnits();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("obatDto", dto);
            model.addAttribute("kat", kat);
            model.addAttribute("supp", supp);
            model.addAttribute("unit", unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertObat";
    }

    @RequestMapping(value = "/saveObat", method = RequestMethod.POST)
    public String saveData(ObatDto obatDto, ModelMap model) throws Exception{
        ObatModels result = obatservices.saveObat(obatDto);
        System.out.println(obatDto.getHarga_beli());
        System.out.println("=================="+result.getId_obat());

        return "redirect:dataobat";
    }

    @GetMapping("/deleteDataObat")
    public String delete(int id_obat){
        obatservices.deleteObat(id_obat);
        return "redirect:dataobat";
    }

    @RequestMapping(value = "/doUpdateDataObat", method = RequestMethod.GET)
    public String doUpdateDataObat(ModelMap model, int id_obat) throws Exception{
        ObatDto dto = obatservices.getObatById(id_obat);
        List<KatModels> kat = katrepo.getKats();
        List<SuppModels> supp = suprepo.getSupps();
        List<UnitModels> unit = unitrepo.getUnits();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("obat", dto);
            model.addAttribute("kat", kat);
            model.addAttribute("supp", supp);
            model.addAttribute("unit", unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateObat";

    }

    @RequestMapping(value = "/updateObat", method = RequestMethod.POST)
    public String updateObat(ObatDto obatDto) throws Exception{
        ObatModels result = obatservices.updateObat(obatDto);
        System.out.println("UPDATE =================="+result.getId_obat());
        return "redirect:dataobat";
    }
}