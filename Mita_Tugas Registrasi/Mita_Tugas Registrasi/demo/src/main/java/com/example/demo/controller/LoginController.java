package com.example.demo.controller;

import com.example.demo.dto.AnggotaDto;
import com.example.demo.dto.MallResponse;
import com.example.demo.models.Anggota;
import com.example.demo.services.EmailService;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/masuk")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("anggota", new Anggota());
        return mav;
    }

    @PostMapping("/cekMasuk")
    public String login(@ModelAttribute("anggota") Anggota anggota, HttpSession session){
        Anggota authadmin = loginService.login(anggota.getUsername(),anggota.getPassword());
        System.out.println(authadmin);
        if(Objects.nonNull(authadmin)){
            session.setAttribute("username",anggota.getUsername());
            emailService.sendEmail(anggota);
            return "redirect:/dashboard";
        }else{
            return "redirect:/masuk";
        }
    }
    @RequestMapping(value = "/keluar",method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("username");
        return "redirect:/masuk";
    }

    @PostMapping("/kirimEmail")
    public MallResponse kirimEmail(Anggota request){
        return emailService.sendEmail(request);
    }
}
