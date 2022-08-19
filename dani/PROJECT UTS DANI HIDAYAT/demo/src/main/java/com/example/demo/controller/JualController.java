package com.example.demo.controller;

import com.example.demo.dto.JualDto;
import com.example.demo.dto.ObatDto;
import com.example.demo.models.JualModels;
import com.example.demo.models.ObatModels;
import com.example.demo.models.PelangganModels;
import com.example.demo.repositories.JualRepository;
import com.example.demo.repositories.ObatRepository;
import com.example.demo.repositories.PelangganRepository;
import com.example.demo.services.JualService;
import com.example.demo.services.ObatService;
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
public class JualController {
    @Autowired
    private JualRepository jualRepository;

    @Autowired
    private JualService jualService;

    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    List<JualModels> jualModels = null;
    JualDto jualDto = new JualDto();
    JualModels result = null;
    List<JualDto> tamp = new ArrayList<>();
    List<ObatModels> obatModels = null;

    @GetMapping("/penjualan")
    public String obat(Model model){
        jualModels = jualRepository.getJual();

        model.addAttribute("Jual", jualModels);
        return "penjualan";
    }

    @RequestMapping(value = "/inputPenjualan", method = RequestMethod.GET)
    public String doInputData(ModelMap model) throws Exception{
        jualDto = new JualDto();

        List<ObatModels> obatModels = obatRepository.getObat();

        model.addAttribute("obatModels", obatModels);
        model.addAttribute("jualDto", jualDto);

        return "inputpenjualan";
    }

    @RequestMapping(value = "/tambahPenjualan", method = RequestMethod.POST)
    public String tambahData(JualDto jual) throws Exception {

        ObatModels obatModels = obatRepository.getObatById(jual.getId_obat());




        jual.setNamaobat(obatModels.getNama());
        jual.setHargajual(obatModels.getHargajual());
        jual.setSubtotal(obatModels.getHargajual() * jual.getBanyak());
        tamp.add(jual);
        return "redirect:/inputPenjualan";
    }

    @RequestMapping(value = "/inputPenjualan2", method = RequestMethod.GET)
    public String inputData2(Model model) throws Exception {
        List<PelangganModels> pelangganModels = pelangganRepository.getPelanggan();

        int total = 0;
        for(JualDto p : tamp){
            System.out.println(p.getSubtotal());

            total += p.getSubtotal();
        }

        model.addAttribute("total", total);
        model.addAttribute("listJual", tamp);
        model.addAttribute("pelanggan", pelangganModels);
        return "inputpenjualan2";
    }

    @RequestMapping(value = "/savePenjualan", method = RequestMethod.POST)
    public String saveData(JualDto jualDto) throws Exception {
        jualDto.getBanyak();
        return "redirect:/inputPenjualan";
    }


}
