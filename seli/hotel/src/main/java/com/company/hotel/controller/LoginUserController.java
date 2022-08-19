package com.company.hotel.controller;

import com.company.hotel.model.User;
import com.company.hotel.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class LoginUserController {
    @Autowired
    LoginUserService loginUserService;

    @RequestMapping("/masukUser")
    public ModelAndView loginUser() {
        ModelAndView mav = new ModelAndView("loginUser");
        mav.addObject("user", new User());
        return mav;
    }


    @PostMapping("/cekmasukUser")
    public String loginUser(@ModelAttribute("user") User user) {
        User authUser = loginUserService.loginUser(user.getUsername(), user.getPassword());

        if (Objects.nonNull(authUser)) {
            return "redirect:/menuUser";
        } else {
            return "redirect:/masukUser";
        }
    }
}
