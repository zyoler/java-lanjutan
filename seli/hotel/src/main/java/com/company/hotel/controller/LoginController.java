package com.company.hotel.controller;

import com.company.hotel.model.Admin;
import com.company.hotel.model.User;
import com.company.hotel.services.LoginAdminService;
import com.company.hotel.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    LoginAdminService loginAdminService;
    LoginUserService loginUserService;

    @RequestMapping("/masuk")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("admin", new Admin());
        return mav;
    }

    @PostMapping("/cekmasuk")
    public String login(@ModelAttribute("admin") Admin admin) {
        Admin authAdmin = loginAdminService.login(admin.getUsername(), admin.getPassword());

        if (Objects.nonNull(authAdmin)) {
            return "redirect:/crud";
        } else {
            return "redirect:/masuk";
        }
    }
}
