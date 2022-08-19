package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.SuppDto;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.SuppRepository;
import UtsJavaApotek.ApotekHerdi.services.SuppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SuppController {
    @Autowired
    SuppRepository supprepo;
    @Autowired
    SuppServices suppservice;

    @Autowired
    ObatRepository obatrepo;

    @GetMapping("/datasupp")
    public String dataSupp(Model model){

        List<SuppModels> supp = supprepo.getSupps();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("sup", supp);
        model.addAttribute("title","Data Pemasok");
        return "datasupp";
    }

    @RequestMapping(value = "/doInsertSupp", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        SuppDto dto = new SuppDto();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("suppDto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertSupp";
    }

    @RequestMapping(value = "/saveSupp", method = RequestMethod.POST)
    public String saveData(SuppDto suppDto, ModelMap model) throws Exception{
        SuppModels result = suppservice.saveSupp(suppDto);
        System.out.println("=================="+result.getId_pem());
        return "redirect:datasupp";
    }

    @GetMapping("/deleteDataSupp")
    public String delete(int id_pem){
        suppservice.deleteSupp(id_pem);
        return "redirect:datasupp";
    }

    @RequestMapping(value = "/doUpdateDataSupp", method = RequestMethod.GET)
    public String doUpdateDataSupp(ModelMap model, int id_pem) throws Exception{
        SuppDto dto = suppservice.getSuppById(id_pem);

        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("supp", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateSupp";

    }

    @RequestMapping(value = "/updateSupp", method = RequestMethod.POST)
    public String updateSupp(SuppDto suppDto) throws Exception{
        SuppModels result = suppservice.updateSupp(suppDto);
        System.out.println("UPDATE =================="+result.getId_pem());
        return "redirect:datasupp";
    }
}
