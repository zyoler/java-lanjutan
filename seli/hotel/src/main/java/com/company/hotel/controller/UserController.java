package com.company.hotel.controller;

import com.company.hotel.dto.UserDto;
import com.company.hotel.model.User;
import com.company.hotel.repositories.UserRepositori;
import com.company.hotel.services.UserService;
import com.company.hotel.services.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    UserRepositori userRepositori;


    @Autowired
    private UserService userService;
    User result = null;
    List<User> user = null;
    UserDto userDto = new UserDto();

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        model.addAttribute("userDto", userDto);
        return "user";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String InsertUser(UserDto userDto, ModelMap model ) throws Exception{
        result = userService.insertUser(userDto);
        userService.sendEmail(userDto);
        return "redirect:/masukUser";
    }

}
