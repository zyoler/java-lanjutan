package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.dto.JualDto;
import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import UtsJavaApotek.ApotekHerdi.models.JualModels;
import UtsJavaApotek.ApotekHerdi.models.ObatModels;
import UtsJavaApotek.ApotekHerdi.models.SuppModels;
import UtsJavaApotek.ApotekHerdi.repositories.JualRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import UtsJavaApotek.ApotekHerdi.services.JualServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JualController {
    @Autowired
    JualRepository jualrepo;

    @Autowired
    JualServices jualServices;

    @Autowired
    ObatRepository obatrepo;

    @GetMapping("/datajual")
    public String datakat(Model model){
        List<JualModels> jual = jualrepo.getJualNative();
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("jual", jual);
        model.addAttribute("title","Data Penjualan");
        return "datajual";
    }

    @GetMapping("/cetakjual")
    public String datacetak(Model model, String ref){

        List<JualModels> jual = jualrepo.getJualByRef(ref);
        Object jual1 = jualrepo.getJualByReff(ref);
        System.out.println(jual);
        System.out.println(jual1);
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("jual", jual);
        model.addAttribute("jual1", jual1);
        model.addAttribute("title","Cetak Struk Penjualan");
        return "invoicereport";
    }

    @RequestMapping(value = "/doInsertJual", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        JualDto dto = new JualDto();
        List<ObatModels> obat = obatrepo.getObatsNative();

        try {
            Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
            Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();

            model.addAttribute("countexp",jumlahexpobat);
            model.addAttribute("countstok",jumlahstokobat);

            model.addAttribute("jualDto", dto);
            model.addAttribute("obats", obat);
            model.addAttribute("title","Tambah Data Penjualan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertJual";
    }

    @RequestMapping(value = "/saveJual", method = RequestMethod.POST)
    public String saveData(@RequestParam(value = "nama_pembeli") String nama_pembeli,
                           @RequestParam(value = "ref") String ref,
                           @RequestParam(value = "tgl_beli") String tgl_beli,
                           @RequestParam(value = "nama_obat[]")String[] nama_obat,
                           @RequestParam(value = "harga_jual[]")Integer[] harga_jual,
                           @RequestParam(value = "banyak[]")Integer[] banyak,
                           @RequestParam(value = "subtotal[]")Integer[] subtotal,
                           @RequestParam(value = "grandtotal")Integer grandtotal, ModelMap model) throws Exception{
        for (int x=0; x<nama_obat.length;x++) {
            JualModels result = jualServices.saveJualByArray(nama_pembeli, ref, tgl_beli, nama_obat[x], harga_jual[x], banyak[x], subtotal[x], grandtotal);
            System.out.println(result);
        }

        System.out.println("=================="+nama_pembeli);
        return "redirect:datajual";
    }

    @GetMapping("/deleteDataJual")
    public String delete(int id_tagihan){
        jualServices.deleteJual(id_tagihan);
        return "redirect:datajual";
    }
}
