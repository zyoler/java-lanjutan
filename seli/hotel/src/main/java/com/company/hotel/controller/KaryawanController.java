package com.company.hotel.controller;

import com.company.hotel.dto.KaryawanDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.KaryawanRepository;
import com.company.hotel.repositories.PengunjungRepository;
import com.company.hotel.services.KaryawanService;
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
public class KaryawanController {
    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    private KaryawanService karyawanService;
    Karyawan result = null;
    List<Karyawan> karyawan = null;
    KaryawanDto karyawanDto = new KaryawanDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/karyawan")
    public String getKaryawan(Model model) throws Exception{
        karyawan = karyawanRepository.getKaryawan();

        model.addAttribute("Karyawan", karyawan);
        model.addAttribute("KaryawanDto",karyawanDto);
        model.addAttribute("cari",cari);
        return "karyawan";
    }

    @RequestMapping(value = "/insertKaryawan", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("karyawanDto", karyawanDto);
        return "insertKaryawan";
    }

    @RequestMapping(value = "/saveKaryawan", method = RequestMethod.POST)
    public String InsertKaryawan(KaryawanDto karyawanDto, ModelMap model ) throws Exception{
        result = karyawanService.insertKaryawan(karyawanDto);
        return "redirect:/karyawan";
    }

    @RequestMapping(value = "/updateDataKaryawan",method = RequestMethod.GET)
    public String updateDataKaryawan(ModelMap model,int id)throws Exception{
        karyawanDto = karyawanService.getKaryawanById(id);

        model.addAttribute("karyawanDto",karyawanDto);

        return  "updateKaryawan";
    }
    @RequestMapping(value = "/saveUpdateKaryawan", method = RequestMethod.POST)
    public String updateDataKaryawan(KaryawanDto karyawanDto, ModelMap model) throws Exception{
        result = karyawanService.updateDataKaryawan(karyawanDto);

        return "redirect:/karyawan";
    }

    @RequestMapping(value="/searchKaryawan",method = RequestMethod.POST)
    public String searchKaryawan(SearchDto search, ModelMap model)throws Exception{
        karyawan = karyawanService.searchKaryawan(search);

        model.addAttribute("Karyawan",karyawan);
        model.addAttribute("cari",cari);

        return "karyawan";
    }
    @GetMapping("/deleteDataKaryawan")
    public String delete(int id){

        karyawanService.deleteDataKaryawan(id);
        return "redirect:/karyawan";
    }
}
