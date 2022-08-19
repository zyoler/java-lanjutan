package com.example.demo.controller;

import com.example.demo.dto.MallResponse;
import com.example.demo.dto.RegistrasiDto;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class RegistrasiController {

    @Autowired
    private EmailService emailService;

    RegistrasiDto regis = new RegistrasiDto();
    RegistrasiDto login = new RegistrasiDto();
    RegistrasiDto tamp = null;

    @RequestMapping(value = "/registrasi", method = RequestMethod.GET)
    public String registrasi(ModelMap model) throws Exception {
        model.addAttribute("registrasi", regis);
        return "registrasi";
    }

    @RequestMapping(value = "/doRegis", method = RequestMethod.POST)
    public String doRegis(RegistrasiDto regis) throws Exception{
        regis.setSubject("Registrasi akun berhasil");
        regis.setText("Registrasi " + regis.getNama() + " berhasil");
        tamp = regis;
        kirimEmail(regis);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) throws Exception {
        model.addAttribute("login", login);
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(RegistrasiDto login) throws Exception{
        if(Objects.equals(tamp.getUsername(), login.getUsername()) && Objects.equals(tamp.getPassword(), login.getPassword())){
            tamp.setSubject("Login berhasil");
            tamp.setText("Anda telah melakukan login");
            kirimEmail(tamp);
            return "menu";
        }else{
            return "redirect:/login";
        }
    }

    @PostMapping("/kirimEmail")
    public MallResponse kirimEmail(RegistrasiDto request){
        return emailService.sendEmail(request);
    }
}
