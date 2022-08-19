package org.neophyte.pertemuan1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("nama","Seli Deslia");
        System.out.println("Hello World..");
        return "home";
    }
}
