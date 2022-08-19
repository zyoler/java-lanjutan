package com.company.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {
    @RequestMapping("/crud")
    public String crud(Model model){
        return "crud";
    }
}
