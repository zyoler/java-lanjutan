package UtsJavaApotek.ApotekHerdi.controllers;


import UtsJavaApotek.ApotekHerdi.dto.LoginDto;
import UtsJavaApotek.ApotekHerdi.models.AdminModels;
import UtsJavaApotek.ApotekHerdi.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    AdminRepository admrepo;
    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/cekLogin", method = RequestMethod.POST)
    public String cekLogin(LoginDto loginDto, HttpSession session) {
        AdminModels admin = admrepo.getAdminByEmail(loginDto.getEmail());
        if(loginDto.getEmail().equalsIgnoreCase(admin.getEmail()) && loginDto.getPassword().equalsIgnoreCase(admin.getPassword())) {
            session.setAttribute("id_adm", admin.getId_adm());
            session.setAttribute("fullname", admin.getFullname());
            session.setAttribute("email", admin.getEmail());
            session.setAttribute("password", admin.getPassword());
            session.setAttribute("status", admin.getStatus());
            return "redirect:/dashboard";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:login";
    }

}
