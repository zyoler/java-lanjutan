package com.company.hotel.controller;

import com.company.hotel.dto.AdminDto;
import com.company.hotel.dto.KamarDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Admin;
import com.company.hotel.model.Kamar;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.AdminRepository;
import com.company.hotel.repositories.KamarRepository;
import com.company.hotel.services.AdminService;
import com.company.hotel.services.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class KamarContoller {
    @Autowired
    KamarRepository kamarRepository;

    @Autowired
    private KamarService kamarService;
    Kamar result = null;
    List<Kamar> kamar = null;
    KamarDto kamarDto = new KamarDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/kamar")
    public String getKamar(Model model) throws Exception{
        kamar = kamarRepository.getKamar();

        model.addAttribute("Kamar", kamar);
        model.addAttribute("kamarDto",kamarDto);
        model.addAttribute("cari",cari);
        return "kamar";
    }


    @RequestMapping(value = "/insertKamar", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("kamarDto", kamarDto);
        return "insertKamar";
    }

    @RequestMapping(value = "/saveKamar", method = RequestMethod.POST)
    public String InsertKamar(KamarDto kamarDto, ModelMap model ) throws Exception{
        result = kamarService.insertKamar(kamarDto);
        return "redirect:/kamar";
    }

    @RequestMapping(value="/searchKamar",method = RequestMethod.POST)
    public String searchKamar(SearchDto search, ModelMap model)throws Exception{
        kamar = kamarService.searchKamar(search);

        model.addAttribute("Kamar",kamar);
        model.addAttribute("cari",cari);

        return "kamar";
    }

    @GetMapping("/deleteDataKamar")
    public String delete(int id){

        kamarService.deleteDataKamar(id);
        return "redirect:/kamar";
    }

    @RequestMapping(value = "/updateDataKamar",method = RequestMethod.GET)
    public String updateDataKamar(ModelMap model,int id)throws Exception{
        kamarDto = kamarService.getKamarById(id);

        model.addAttribute("kamarDto",kamarDto);

        return  "updateKamar";
    }
    @RequestMapping(value = "/saveUpdateKamar", method = RequestMethod.POST)
    public String updateDataKamar(KamarDto kamarDto, ModelMap model) throws Exception{
        result = kamarService.updateDataKamar(kamarDto);

        return "redirect:/kamar";
    }

}
