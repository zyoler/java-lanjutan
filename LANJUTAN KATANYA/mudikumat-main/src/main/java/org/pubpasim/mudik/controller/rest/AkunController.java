package org.pubpasim.mudik.controller.rest;

import org.modelmapper.ModelMapper;
import org.pubpasim.mudik.dto.AkunDto;
import org.pubpasim.mudik.model.Akun;
import org.pubpasim.mudik.repository.AkunRepository;
import org.pubpasim.mudik.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AkunController {

    private final AkunRepository akunRepository;
    private final AkunService akunService;
    private final ModelMapper modelMapper;

    @Autowired
    public AkunController(AkunRepository akunRepository, AkunService akunService, ModelMapper modelMapper) {
        this.akunRepository = akunRepository;
        this.akunService = akunService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/akun/{id}")
    Akun getAkun(@PathVariable String id) {
        return akunRepository.findById(id).orElse(null);
    }

    @GetMapping("/semua-akun")
    List<AkunDto> getSemuaAkun() {
        return akunService.getSemuaAkun();
    }

    @GetMapping("/akun/{id}/deskripsi")
    String getDeskripsi(@PathVariable String id) {
        return akunService.getDeskripsi(id);
    }

    @GetMapping("/kelola/akun")
    public List<Akun> getAllAkun() {
        return akunRepository.findAll();
    }

    @PostMapping("/kelola/akun")
    Akun buatAkun(@RequestBody Akun akun) {
        return akunRepository.save(akun);
    }

    @PutMapping("/kelola/akun/{id}")
    Akun editAkun(@RequestBody Akun akunBaru, @PathVariable String id) {
        return akunRepository.findById(id).map(akun -> {
            akun.setNamaPengguna(akunBaru.getNamaPengguna());
            akun.setNama(akunBaru.getNama());
            akun.setJenisKelamin(akunBaru.getJenisKelamin());
            akun.setDaerahAsal(akunBaru.getDaerahAsal());
            akun.setTempatLahir(akunBaru.getTempatLahir());
            akun.setTanggalLahir(akunBaru.getTanggalLahir());
            akun.setProgramStudi(akunBaru.getProgramStudi());
            akun.setAngkatan(akunBaru.getAngkatan());
            return akunRepository.save(akun);
        }).orElseGet(() -> {
            akunBaru.setId(id);
            return akunRepository.save(akunBaru);
        });
    }

    @DeleteMapping("/kelola/akun/{id}")
    void hapusAkun(@PathVariable String id) {
        akunRepository.deleteById(id);
    }

}
