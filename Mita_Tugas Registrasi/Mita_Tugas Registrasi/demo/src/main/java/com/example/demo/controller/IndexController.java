package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/masuk");
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

}
