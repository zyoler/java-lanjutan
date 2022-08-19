package org.pubpasim.mudik.controller.rest;

import org.pubpasim.mudik.model.Kabupaten;
import org.pubpasim.mudik.model.Provinsi;
import org.pubpasim.mudik.repository.ProvinsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provinsi")
public class ProvinsiController {

    private final ProvinsiRepository provinsiRepository;

    @Autowired
    public ProvinsiController(ProvinsiRepository provinsiRepository) {
        this.provinsiRepository = provinsiRepository;
    }

    @GetMapping("/{id}")
    Provinsi getProvinsi(@PathVariable int id) {
        return provinsiRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/kabupaten")
    List<Kabupaten> getKabupatenProvinsi(@PathVariable int id) {
        return getProvinsi(id).getKabupaten();
    }

}
