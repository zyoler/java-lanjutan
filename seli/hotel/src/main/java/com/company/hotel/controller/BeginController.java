package com.company.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeginController {
    @RequestMapping("/begin")
    public String begin(Model model){
        return "begin";
    }
}
