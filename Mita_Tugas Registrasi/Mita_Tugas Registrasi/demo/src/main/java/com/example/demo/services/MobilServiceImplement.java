package com.example.demo.services;

import com.example.demo.dto.MobilDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Member;
import com.example.demo.models.Mobil;
import com.example.demo.repositories.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobilServiceImplement implements MobilService {
    @Autowired
    MobilRepository mobilRepository;
    @Override
    public Mobil insertMobil(MobilDto mobilDto){
        Mobil model = new Mobil();
        Mobil result = new Mobil();
        try {
            model.setNama_mobil(mobilDto.getNama_mobil());
            model.setMerk(mobilDto.getMerk());
            model.setWarna(mobilDto.getWarna());
            model.setTahun(mobilDto.getTahun());
            model.setSeri_kota(mobilDto.getSeri_kota());
            model.setNo_polisi(mobilDto.getNo_polisi());
            model.setHuruf(mobilDto.getHuruf());
            model.setStatus(mobilDto.getStatus());
            model.setHarga(mobilDto.getHarga());
            model.setFoto_mobil(mobilDto.getFoto_mobil());
            result = mobilRepository.save(model);
        }catch (Exception e){
        }
        return result;
    }
    @Override
    public Boolean deleteMobil(int id){
        Mobil model = mobilRepository.getById(id);
        mobilRepository.delete(model);
        return true;
    }
    @Override
    public MobilDto getMobilById(int id){
        Mobil model = mobilRepository.getById(id);
        MobilDto dto = new MobilDto();
        dto.setId_mobil(model.getId_mobil());
        dto.setNama_mobil(model.getNama_mobil());
        dto.setMerk(model.getMerk());
        dto.setWarna(model.getWarna());
        dto.setTahun(model.getTahun());
        dto.setSeri_kota(model.getSeri_kota());
        dto.setNo_polisi(model.getNo_polisi());
        dto.setHuruf(model.getHuruf());
        dto.setStatus(model.getStatus());
        dto.setHarga(model.getHarga());
        dto.setFoto_mobil(model.getFoto_mobil());

        return dto;
    }

    @Override
    public Mobil updateMobil(MobilDto mobilDto){
        Mobil model = new Mobil();
        Mobil result = new Mobil();
        try {
            model.setId_mobil(mobilDto.getId_mobil());
            model.setNama_mobil(mobilDto.getNama_mobil());
            model.setMerk(mobilDto.getMerk());
            model.setWarna(mobilDto.getWarna());
            model.setTahun(mobilDto.getTahun());
            model.setSeri_kota(mobilDto.getSeri_kota());
            model.setNo_polisi(mobilDto.getNo_polisi());
            model.setHuruf(mobilDto.getHuruf());
            model.setStatus(mobilDto.getStatus());
            model.setHarga(mobilDto.getHarga());
            model.setFoto_mobil(mobilDto.getFoto_mobil());
            result = mobilRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }
    @Override
    public List<Mobil> searchMobil(SearchDto searchDto){
        List<Mobil> listMobil = mobilRepository.getMobil(searchDto.getCari());

        return listMobil;
    }
}
