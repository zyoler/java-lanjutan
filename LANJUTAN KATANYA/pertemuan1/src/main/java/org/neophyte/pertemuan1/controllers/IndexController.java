package org.neophyte.pertemuan1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/uploadExcel");
    }
}
