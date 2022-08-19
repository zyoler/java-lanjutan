package com.company.hotel.controller;

import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.dto.UserDto;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.PengunjungRepository;
import com.company.hotel.services.PengunjungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PengunjungController {
    @Autowired
    PengunjungRepository pengunjungRepository;

    @Autowired
    private PengunjungService pengunjungService;
    Pengunjung result = null;
    List<Pengunjung> pengunjung = null;
    PengunjungDto pengunjungDto = new PengunjungDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/pengunjung")
    public String getPengunjung(Model model) throws Exception{
        pengunjung = pengunjungRepository.getPengunjung();

        model.addAttribute("Pengunjung", pengunjung);
        model.addAttribute("PengunjungDto",pengunjungDto);
        model.addAttribute("cari",cari);
        return "pengunjung";
    }

    @RequestMapping(value = "/insertPengunjung", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("pengunjungDto", pengunjungDto);
        return "insertPengunjung";
    }

    @RequestMapping(value = "/savePengunjung", method = RequestMethod.POST)
    public String InsertPengunjung(PengunjungDto pengunjungDto, ModelMap model ) throws Exception{
        result = pengunjungService.insertPengunjung(pengunjungDto);

        return "redirect:/pengunjung";
    }
    @RequestMapping(value = "/insertCheckInUser", method = RequestMethod.GET)
    public String doInsertDataa(ModelMap model) throws Exception{
        model.addAttribute("pengunjungDto", pengunjungDto);
        return "insertCheckInUser";
    }

    @RequestMapping(value = "/saveCheckInUser", method = RequestMethod.POST)
    public String InsertCheckInUser(PengunjungDto pengunjungDto, ModelMap model ) throws Exception{
        result = pengunjungService.insertCheckInUser(pengunjungDto);
        pengunjungService.sendEmail(pengunjungDto);
        return "redirect:/InsertCheckInUser2";
    }
    @GetMapping("/deleteDataPengunjung")
    public String delete(int id){

        pengunjungService.deleteDataPengunjung(id);
        return "redirect:/pengunjung";
    }
    @RequestMapping(value = "/updateDataPengunjung",method = RequestMethod.GET)
    public String updateDataPengunjung(ModelMap model,int id)throws Exception{
        pengunjungDto = pengunjungService.getPengunjungById(id);

        model.addAttribute("pengunjungDto",pengunjungDto);

        return  "updatePengunjung";
    }
    @RequestMapping(value = "/saveUpdatePengunjung", method = RequestMethod.POST)
    public String updateDataPengunjung(PengunjungDto pengunjungDto, ModelMap model) throws Exception{
        result = pengunjungService.updateDataPengunjung(pengunjungDto);

        return "redirect:/pengunjung";
    }

    @RequestMapping(value="/searchPengunjung",method = RequestMethod.POST)
    public String searchPengunjung(SearchDto search, ModelMap model)throws Exception{
        pengunjung = pengunjungService.searchPengunjung(search);

        model.addAttribute("Pengunjung",pengunjung);
        model.addAttribute("cari",cari);

        return "pengunjung";
    }
}
