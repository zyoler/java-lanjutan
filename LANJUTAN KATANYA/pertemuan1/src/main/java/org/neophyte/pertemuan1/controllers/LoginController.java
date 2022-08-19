package org.neophyte.pertemuan1.controllers;

import org.neophyte.pertemuan1.model.Admin;
import org.neophyte.pertemuan1.services.loginService;
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
    loginService loginService;

    @RequestMapping("/masuk")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("admin", new Admin());
        return mav;
    }

    @PostMapping("/cekmasuk")
    public String login(@ModelAttribute("admin") Admin admin) {
        Admin authAdmin = loginService.login(admin.getUsername(), admin.getPassword());

        if (Objects.nonNull(authAdmin)) {
            return "redirect:/getMahasiswa";
        } else {
            return "redirect:/masuk";
        }
    }
}
