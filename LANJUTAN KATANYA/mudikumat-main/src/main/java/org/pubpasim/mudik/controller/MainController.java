package org.pubpasim.mudik.controller;

import org.pubpasim.mudik.DetailAkun;
import org.pubpasim.mudik.MudikUmatApplication;
import org.pubpasim.mudik.model.Mudik;
import org.pubpasim.mudik.repository.MudikRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class MainController {

    private final MudikRepository mudikRepository;

    public MainController(MudikRepository mudikRepository) {
        this.mudikRepository = mudikRepository;
    }

    @GetMapping("/")
    public String beranda(HttpServletRequest request, Model model) {

        model.addAttribute("periode", MudikUmatApplication.periode);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof DetailAkun) {
                model.addAttribute("principal", principal);
//                if (request.isUserInRole("ROLE_ADMIN")) {
//                    return "redirect:/kelola/akun";
//                }
            }
        }

        return "beranda";
    }

    @GetMapping("/mudik/{id}")
    public String mudikSaya(@PathVariable String id, Model model) {
        Optional<Mudik> mudik = mudikRepository.findById(id);
        model.addAttribute("mudik", mudik.orElse(null));
        return "mudik/detail";
    }

    @GetMapping("/tentang")
    public String tentang() {
        return "tentang";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ModelAttribute
    public void menuAdmin(Model model) {
    }

}