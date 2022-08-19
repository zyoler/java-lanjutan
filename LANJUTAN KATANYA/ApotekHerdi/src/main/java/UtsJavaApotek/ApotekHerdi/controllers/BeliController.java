package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.BeliDto;
import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.repositories.BeliRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.repositories.SuppRepository;
import UtsJavaApotek.ApotekHerdi.services.BeliServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BeliController {
    @Autowired
    BeliRepository belirepo;

    @Autowired
    SuppRepository supprepo;

    @Autowired
    ObatRepository obatrepo;

    @Autowired
    BeliServices beliservice;

    @GetMapping("/databeli")
    public String databeli(Model model){

        List<BeliModels> beli = belirepo.getBeli();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("beli", beli);
        model.addAttribute("title","Data Pembelian");
        return "databeli";
    }

    @GetMapping("/ceatkbeli")
    public String datacetak(Model model, String ref){

        List<BeliModels> beli = belirepo.getBeliByRef(ref);
        Object beli1 = belirepo.getBeliByReff(ref);
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        System.out.println(beli);
        System.out.println(beli1);
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("beli", beli);
        model.addAttribute("beli1", beli1);
        model.addAttribute("title","Cetak Struk Pembelian");
        return "purchasereport";
    }


    @RequestMapping(value = "/doInsertBeli", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        BeliDto dto = new BeliDto();
        List<ObatModels> obat = obatrepo.getObatsNative();
        List<SuppModels> supp = supprepo.getSupps();
        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);
            model.addAttribute("beliDto", dto);
            model.addAttribute("obat", obat);
            model.addAttribute("supp", supp);
            model.addAttribute("title","Tambah Data Pembelian");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertBeli";
    }

    @RequestMapping(value = "/saveBeli", method = RequestMethod.POST)
    public String saveData(BeliDto beliDto, ModelMap model) throws Exception{
        BeliModels result = beliservice.saveBeli(beliDto);
        return "redirect:databeli";
    }

    @GetMapping("/deleteDataBeli")
    public String delete(int id_pembelian){
        beliservice.deleteBeli(id_pembelian);
        return "redirect:databeli";
    }

}
