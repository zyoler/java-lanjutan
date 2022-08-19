package org.pubpasim.mudik.controller.rest;

import org.pubpasim.mudik.model.Kabupaten;
import org.pubpasim.mudik.model.Mudik;
import org.pubpasim.mudik.repository.KabupatenRepository;
import org.pubpasim.mudik.repository.MudikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MudikController {

    private final MudikRepository mudikRepository;
    private final KabupatenRepository kabupatenRepository;

    @Autowired
    public MudikController(MudikRepository mudikRepository, KabupatenRepository kabupatenRepository) {
        this.mudikRepository = mudikRepository;
        this.kabupatenRepository = kabupatenRepository;
    }

    @GetMapping("/mudik/{id}")
    Optional<Mudik> getMudik(@PathVariable String id) {
        return mudikRepository.findById(id).map(mudik -> {
            mudik.setNamaPemudik(mudik.getPemudik().getNama());
            return mudik;
        });
    }

    @GetMapping("/mudik/kabupaten")
    List<Kabupaten> getKabupaten() {
        List<Kabupaten> daftarKabupaten = kabupatenRepository.findKabupatenMudik();
        for (Kabupaten kabupaten : daftarKabupaten) {
            List<String> daftarNamaPemudik = new ArrayList<>();
            for (Mudik mudik : kabupaten.getMudik()) {
                daftarNamaPemudik.add(mudik.getPemudik().getNama());
            }
            Collections.sort(daftarNamaPemudik);
            kabupaten.setDaftarNamaPemudik(daftarNamaPemudik);
        }
        return daftarKabupaten;
    }

    @GetMapping("/kelola/mudik")
    public List<Mudik> getAllMudik() {
        return mudikRepository.findAll();
    }

    @PostMapping("/kelola/mudik")
    Mudik buatMudik(@RequestBody Mudik mudik) {
        return mudikRepository.save(mudik);
    }

    @PutMapping("/kelola/mudik/{id}")
    Mudik editMudik(@RequestBody Mudik mudikBaru, @PathVariable String id) {
        return mudikRepository.findById(id).map(mudik -> {
            mudik.setBerangkat(mudikBaru.getBerangkat());
            mudik.setKembali(mudikBaru.getKembali());
            mudik.setTujuan(mudikBaru.getTujuan());
            return mudikRepository.save(mudik);
        }).orElseGet(() -> {
            mudikBaru.setId(id);
            return mudikRepository.save(mudikBaru);
        });
    }

    @DeleteMapping("/kelola/mudik/{id}")
    void hapusMudik(@PathVariable String id) {
        mudikRepository.deleteById(id);
    }

}
