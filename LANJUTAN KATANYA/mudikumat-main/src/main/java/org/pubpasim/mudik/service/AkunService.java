package org.pubpasim.mudik.service;

import org.pubpasim.mudik.dto.AkunDto;
import org.pubpasim.mudik.model.Akun;
import org.pubpasim.mudik.model.JabatanAkun;
import org.pubpasim.mudik.repository.AkunRepository;
import org.pubpasim.mudik.repository.JabatanAkunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AkunService {

    private final AkunRepository akunRepository;
    private final JabatanAkunRepository jabatanAkunRepository;

    @Autowired
    public AkunService(AkunRepository akunRepository, JabatanAkunRepository jabatanAkunRepository) {
        this.akunRepository = akunRepository;
        this.jabatanAkunRepository = jabatanAkunRepository;
    }

    public String getDeskripsi(String id) {
        return akunRepository.findById(id).map(akun -> {
            String deskripsi;
            List<JabatanAkun> jabatanAkun = jabatanAkunRepository.findByAkunId(akun.getId(), 2020, PageRequest.of(0, 1));
            if (jabatanAkun.size() > 0) {
                JabatanAkun jabatanUtama = jabatanAkun.get(0);
                deskripsi = jabatanUtama.getJabatan().getNama();
                if (jabatanUtama.getDivisi() != null) {
                    deskripsi += " " + jabatanUtama.getDivisi().getNama();
                }
                deskripsi += " " + jabatanUtama.getOrganisasi().getAkronim();
            } else {
                deskripsi = "PUB " + akun.getAngkatan().getNomor() + " " + akun.getAngkatan().getNama();
            }
            return deskripsi;
        }).orElse(null);
    }

    public List<AkunDto> getSemuaAkun() {
        List<Akun> daftarAkun = akunRepository.findAll();
        List<AkunDto> daftarAkunDto = new ArrayList<>();
        for (Akun akun : daftarAkun) {
            AkunDto akunDto = new AkunDto();
            akunDto.setNama(akun.getNama());
            if (akun.getAngkatan() != null) {
                akunDto.setNamaAngkatan(akun.getAngkatan().getNama());
            } else {
                akunDto.setNamaAngkatan("-");
            }
            daftarAkunDto.add(akunDto);
        }
        return daftarAkunDto;
    }
}
