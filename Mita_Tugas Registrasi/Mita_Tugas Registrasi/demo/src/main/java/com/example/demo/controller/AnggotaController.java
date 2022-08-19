package com.example.demo.controller;

import com.example.demo.dto.AnggotaDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.models.Anggota;
import com.example.demo.repositories.AnggotaRepository;
import com.example.demo.services.AnggotaService;
import com.example.demo.services.EmailService;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Objects;

@Controller
public class AnggotaController {
    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AnggotaService anggotaService;

    List<Anggota> anggota = null;
    AnggotaDto anggotaDto = new AnggotaDto();
    Anggota result = null;

    @RequestMapping(value = "/createAnggota", method = RequestMethod.GET)
    public String doCreateAnggota(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("anggotaDto",anggotaDto);
        return "createAnggota";
    }

    @RequestMapping(value = "/saveAnggota", method = RequestMethod.POST)
    public String saveAnggota(AnggotaDto anggotaDto, ModelMap modelMap) throws Exception{
        result = anggotaService.insertAnggota(anggotaDto);
        //emailService.sendEmail(anggotaDto);
        return "redirect:/masuk";
    }

    @PostMapping("/cekEmail")
    public String cekEmail(@ModelAttribute("anggotaDto") Anggota anggota){
        if(anggota.getEmail().equals("mitairuz@gmail.com")){
            return "/saveUpdateAnggota";
        }else{
            return "redirect:/masuk";

        }
    }
    @RequestMapping(value = "/updateAnggota", method = RequestMethod.GET)
    public String updateAnggota(ModelMap modelMap) throws Exception{
        anggotaDto = anggotaService.getAnggotaById(1);
        modelMap.addAttribute("anggotaDto",anggotaDto);
        return "updateAnggota";
    }

    @RequestMapping(value = "/saveUpdateAnggota")
    public String updateMember(AnggotaDto anggotaDto) throws  Exception{
        result = anggotaService.updateAnggota(anggotaDto);
        return "redirect:/masuk";
    }
}
