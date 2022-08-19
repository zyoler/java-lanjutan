package org.pubpasim.mudik.controller.advice;

import org.pubpasim.mudik.model.Akun;
import org.pubpasim.mudik.model.Angkatan;
import org.pubpasim.mudik.model.ProgramStudi;
import org.pubpasim.mudik.model.Provinsi;
import org.pubpasim.mudik.repository.AkunRepository;
import org.pubpasim.mudik.repository.AngkatanRepository;
import org.pubpasim.mudik.repository.ProgramStudiRepository;
import org.pubpasim.mudik.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    private final AkunRepository akunRepository;
    private final ProvinsiRepository provinsiRepository;
    private final ProgramStudiRepository programStudiRepository;
    private final AngkatanRepository angkatanRepository;

    @Autowired
    public GlobalControllerAdvice(AkunRepository akunRepository, ProvinsiRepository provinsiRepository, ProgramStudiRepository programStudiRepository, AngkatanRepository angkatanRepository) {
        this.akunRepository = akunRepository;
        this.provinsiRepository = provinsiRepository;
        this.programStudiRepository = programStudiRepository;
        this.angkatanRepository = angkatanRepository;
    }

    @ModelAttribute
    public void myMethod(HttpServletRequest request, Model model) {
        List<Akun> daftarAkun = akunRepository.findAll();
        List<Provinsi> daftarProvinsi = provinsiRepository.findAll();
        List<ProgramStudi> daftarProgramStudi = programStudiRepository.findAll();
        List<Angkatan> daftarAngkatan = angkatanRepository.findAll();
        Entitas[] daftarEntitas = {
                new Entitas("mudik", "Mudik"),
                new Entitas("akun", "Akun"),
                new Entitas("angkatan", "Angkatan")
        };

        model.addAttribute("daftarProvinsi", daftarProvinsi);
        model.addAttribute("daftarProgramStudi", daftarProgramStudi);
        model.addAttribute("daftarAngkatan", daftarAngkatan);
        if (request.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("daftarAkun", daftarAkun);
            model.addAttribute("daftarEntitas", daftarEntitas);
        }

    }

}

class Entitas {
    public String id, nama;

    public Entitas(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }
}