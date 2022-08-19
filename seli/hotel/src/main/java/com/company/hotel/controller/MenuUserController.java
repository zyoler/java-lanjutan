package com.company.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MenuUserController {
    @RequestMapping("/menuUser")
    public String menuUser(Model model){
        return "menuUser";
    }
}
