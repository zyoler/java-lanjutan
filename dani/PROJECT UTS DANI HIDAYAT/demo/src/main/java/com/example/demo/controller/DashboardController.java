package com.example.demo.controller;

import com.example.demo.repositories.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/dashboard")
    public String dashboard(ModelMap model){
        model.addAttribute("jumlahPegawai", dashboardRepository.getCountPegawai());
        model.addAttribute("jumlahPelanggan", dashboardRepository.getCountPelanggan());
        model.addAttribute("jumlahPemasok", dashboardRepository.getCountPemasok());
        model.addAttribute("jumlahKategori", dashboardRepository.getCountKategori());
        model.addAttribute("jumlahObat", dashboardRepository.getCountObat());
        return "dashboard";
    }
}
