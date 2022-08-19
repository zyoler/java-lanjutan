package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.KatDto;
import UtsJavaApotek.ApotekHerdi.dto.ObatDto;
import UtsJavaApotek.ApotekHerdi.models.KatModels;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.models.UnitModels;
import UtsJavaApotek.ApotekHerdi.repositories.KatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.services.KatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class KatController {
    @Autowired
    KatRepository katrepo;
    @Autowired
    KatServices katservice;
    @Autowired
    ObatRepository obatrepo;

    @GetMapping("/datakat")
    public String datakat(Model model){

        List<KatModels> kat = katrepo.getKats();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("kats", kat);
        model.addAttribute("title","Data Kategori");
        return "datakat";
    }

    @RequestMapping(value = "/doInsertKat", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        KatDto dto = new KatDto();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("katDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertKat";
    }

    @RequestMapping(value = "/saveKat", method = RequestMethod.POST)
    public String saveData(KatDto katDto, ModelMap model) throws Exception{
        KatModels result = katservice.saveKat(katDto);
        System.out.println("=================="+result.getId_kat());
        return "redirect:datakat";
    }

    @GetMapping("/deleteDataKat")
    public String delete(int id_kat){
        katservice.deleteKat(id_kat);
        return "redirect:datakat";
    }

    @RequestMapping(value = "/doUpdateDataKat", method = RequestMethod.GET)
    public String doUpdateDataKat(ModelMap model, int id_kat) throws Exception{
        KatDto dto = katservice.getKatById(id_kat);

        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("kat", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateKat";
    }

    @RequestMapping(value = "/updateKat", method = RequestMethod.POST)
    public String updateObat(KatDto katDto) throws Exception{
        KatModels result = katservice.updateKat(katDto);
        System.out.println("UPDATE =================="+result.getId_kat());
        return "redirect:datakat";
    }
}
