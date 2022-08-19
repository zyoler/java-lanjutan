package com.example.demo.controllers;

import com.example.demo.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class LoginController {

    @RequestMapping("/masuk");
    public ModelAndView login(){

    }

    @PostMapping("/cekmasuk")
    public String login(@ModelAtrribute("admin") Admin admin){
        Admin authadmin = logiService.login(admin.getUsername(),admin.getPassword);
        System.out.println(authadmin);
        if(Objects.nonNull(authadmin)){
            return "redirect:/getMahasiswa
        }else{
            return "redirect:/masuk";
        }
    }
}
