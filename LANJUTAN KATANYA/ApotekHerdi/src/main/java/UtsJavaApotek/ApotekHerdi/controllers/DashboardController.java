package UtsJavaApotek.ApotekHerdi.controllers;

import UtsJavaApotek.ApotekHerdi.repositories.*;
import UtsJavaApotek.ApotekHerdi.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @Autowired
    AdminRepository admrepo;

    @Autowired
    ObatRepository obatrepo;

    @Autowired
    KatRepository katrepo;

    @Autowired
    UnitRepository unitrepo;

    @Autowired
    SuppRepository suprepo;

    @Autowired
    JualRepository jualrepo;

    @Autowired
    BeliRepository belirepo;

    @Autowired
    LoginServices logservice;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){
        Integer jumlahobat = obatrepo.getObatSumNative();
        Integer jumlahexpobat = obatrepo.getObatCountExpNative();
        Integer jumlahstokobat = obatrepo.getObatCountOutStokNative();
        Integer jumlahunit = unitrepo.getCountUnitNative();
        Integer jumlahsupp = suprepo.getCountSuppNative();
        Integer jumlahkat = katrepo.getCountKatNative();
        Integer jumlahjual = jualrepo.jumlahjual();
        Integer jumlahbeli = belirepo.jumlahbeli();

        model.addAttribute("jumlahobat",jumlahobat);
        model.addAttribute("countexp",jumlahexpobat);
        model.addAttribute("countstok",jumlahstokobat);
        model.addAttribute("jumlahunit",jumlahunit);
        model.addAttribute("jumlahkat",jumlahkat);
        model.addAttribute("jumlahsup",jumlahsupp);
        model.addAttribute("jumlahjual",jumlahjual);
        model.addAttribute("jumlahbeli",jumlahbeli);

        return "dashboard";
    }

}
