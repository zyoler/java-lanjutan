package com.example.demo.controller;

import com.example.demo.dto.MallRequest;
import com.example.demo.dto.MallResponse;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MallController {
//
//    @Autowired
//    private EmailService emailService;
//
//    MallRequest request = new MallRequest();
//
//    @RequestMapping(value = "/createEmail", method = RequestMethod.GET)
//    public String createEmail(ModelMap model) throws Exception {
//        model.addAttribute("createEmail", request);
//        return "email";
//    }
//
//    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
//    public String saveData(MallRequest request) throws Exception{
//        kirimEmail(request);
//        return "/masuk";
//    }
//
//    @PostMapping("/kirimEmail")
//    public MallResponse kirimEmail(MallRequest request){
//        return emailService.sendEmail(request);
//    }
}
