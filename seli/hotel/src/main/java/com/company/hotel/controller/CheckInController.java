package com.company.hotel.controller;

import com.company.hotel.dto.*;
import com.company.hotel.model.CheckIn;
import com.company.hotel.model.Kamar;
import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.CheckInRepository;
import com.company.hotel.repositories.KamarRepository;
import com.company.hotel.repositories.KaryawanRepository;
import com.company.hotel.repositories.PengunjungRepository;
import com.company.hotel.services.CheckInService;
import com.company.hotel.services.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckInController {

    @Autowired
    CheckInRepository checkInRepository;
    @Autowired
    PengunjungRepository pengunjungRepository;
    @Autowired
    KaryawanRepository karyawanRepository;
    @Autowired
    KamarRepository kamarRepository;

    @Autowired
    private CheckInService checkInService;
    CheckIn result = null;
    List<CheckIn> checkIn = null;
    List<Pengunjung> pengunjung = null;
    List<Karyawan> karyawan = null;
    List<Kamar> kamar = null;
    CheckInDto checkInDto = new CheckInDto();
    SearchDto cari = new SearchDto();

    @GetMapping("/checkIn")
    public String getCheckIn(Model model) throws Exception{
        checkIn = checkInRepository.getCheckIn();

        model.addAttribute("CheckIn", checkIn);
        model.addAttribute("checkInDto",checkInDto);
        model.addAttribute("cari",cari);
        return "checkIn";
    }
    @RequestMapping(value = "/insertCheckIn", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        pengunjung = pengunjungRepository.getPengunjung();
        karyawan = karyawanRepository.getKaryawan();
        kamar = kamarRepository.getKamar();
        model.addAttribute("checkInDto", checkInDto);
        model.addAttribute("listPengunjung",pengunjung);
        model.addAttribute("listKaryawan",karyawan);
        model.addAttribute("listKamar",kamar);
        return "insertCheckIn";
    }

    @RequestMapping(value = "/saveCheckIn", method = RequestMethod.POST)
    public String InsertCheckIn(CheckInDto checkInDto, ModelMap model ) throws Exception{
        result = checkInService.insertCheckIn(checkInDto);
        return "redirect:/checkIn";
    }

    @RequestMapping(value = "/InsertCheckInUser2", method = RequestMethod.GET)
    public String doInsertDataa(ModelMap model) throws Exception{
        pengunjung = pengunjungRepository.getPengunjung();
        karyawan = karyawanRepository.getKaryawan();
        kamar = kamarRepository.getKamar();
        model.addAttribute("checkInDto", checkInDto);
        model.addAttribute("listPengunjung",pengunjung);
        model.addAttribute("listKaryawan",karyawan);
        model.addAttribute("listKamar",kamar);
        return "InsertCheckInUser2";
    }

    @RequestMapping(value = "/saveCheckInUser2", method = RequestMethod.POST)
    public String InsertCheckInUser2(CheckInDto checkInDto, ModelMap model ) throws Exception{
        result = checkInService.insertCheckInUser2(checkInDto);
        return "redirect:/begin";
    }

    @RequestMapping(value = "/updateDataCheckIn",method = RequestMethod.GET)
    public String updateDataCheckIn(ModelMap model,int id)throws Exception{
        checkInDto = checkInService.getCheckInById(id);
        pengunjung = pengunjungRepository.getPengunjung();
        karyawan = karyawanRepository.getKaryawan();
        kamar = kamarRepository.getKamar();
        model.addAttribute("checkInDto",checkInDto);
        model.addAttribute("listPengunjung",pengunjung);
        model.addAttribute("listKaryawan",karyawan);
        model.addAttribute("listKamar",kamar);

        return  "updateCheckIn";
    }
    @RequestMapping(value = "/saveUpdateCheckIn", method = RequestMethod.POST)
    public String updateDataCheckiIn(CheckInDto checkInDto, ModelMap model) throws Exception{
        result = checkInService.updateDataCheckIn(checkInDto);

        return "redirect:/checkIn";
    }
    @RequestMapping(value="/searchCheckIn",method = RequestMethod.POST)
    public String searchCheckIn(SearchDto search, ModelMap model)throws Exception{
        checkIn = checkInService.searchCheckIn(search);

        model.addAttribute("CheckIn",checkIn);
        model.addAttribute("cari",cari);

        return "checkIn";
    }
    @GetMapping("/deleteDataCheckIn")
    public String delete(int id){

        checkInService.deleteDataCheckIn(id);
        return "redirect:/checkIn";
    }
}
