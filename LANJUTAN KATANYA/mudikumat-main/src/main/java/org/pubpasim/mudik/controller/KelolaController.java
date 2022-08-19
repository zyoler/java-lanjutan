package org.pubpasim.mudik.controller;

import org.pubpasim.mudik.model.*;
import org.pubpasim.mudik.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kelola")
public class KelolaController {

    private final MudikRepository mudikRepository;
    private final AngkatanRepository angkatanRepository;

    @Autowired
    public KelolaController(MudikRepository mudikRepository, AkunRepository akunRepository, AngkatanRepository angkatanRepository) {
        this.mudikRepository = mudikRepository;
        this.angkatanRepository = angkatanRepository;
    }

    @GetMapping("/mudik")
    public String kelolaMudik(Model model) {
        List<Mudik> daftarMudik = mudikRepository.findAll();
        model.addAttribute("daftarMudik", daftarMudik);
        return "mudik/kelola";
    }

    @GetMapping("/akun")
    public String kelolaAkun(Model model) {
        return "akun/kelola";
    }

    @GetMapping("/angkatan")
    public String kelolaAngkatan(Model model) {
        List<Angkatan> daftarAngkatan = angkatanRepository.findAll();
        model.addAttribute("daftarAkun", daftarAngkatan);
        return "angkatan/kelola";
    }

}