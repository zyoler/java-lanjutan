package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.repositories.BeliRepository;
import UtsJavaApotek.ApotekHerdi.repositories.JualRepository;
import UtsJavaApotek.ApotekHerdi.repositories.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GrafikController {
    @Autowired
    ObatRepository obatrepo;

    @Autowired
    JualRepository jualrepo;

    @Autowired
    BeliRepository belirepo;

    @GetMapping("/grafikdata")
    public String grafikdata(Model model){
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("title","Grafik Laporan Data");
        return "grafikdata";
    }

    @GetMapping("/grafikBeli")
    public String grafikdataBeli(Model model){
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("title","Grafik Laporan Data Pembelian");
        return "grafikbeli";
    }

    @GetMapping("/grafikJual")
    public String grafikdataJual(Model model){
        Integer jumlahexpobat =  obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("title","Grafik Laporan Data Penjualan");
        return "grafikjual";
    }
}
