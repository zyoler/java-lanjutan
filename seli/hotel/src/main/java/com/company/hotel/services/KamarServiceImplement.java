package com.company.hotel.services;

import com.company.hotel.dto.KamarDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Kamar;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.KamarRepository;
import com.company.hotel.repositories.PengunjungRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Setter
@Getter
@Service
public class KamarServiceImplement implements KamarService{
    @Autowired
    KamarRepository kamarRepository;

    @Override
    public KamarDto getKamarById(int id) {
            Kamar model = kamarRepository.getById(id);
            KamarDto dto = new KamarDto();

            dto.setId(model.getId());
            dto.setTipe_kamar(model.getTipe_kamar());
            dto.setFasilitas(model.getFasilitas());
            dto.setHarga(model.getHarga());
            dto.setKapasitas(model.getKapasitas());
            dto.setStatus(model.getStatus());
            return dto;
    }

    @Override
    public Kamar insertKamar(KamarDto kamarDto) {
        Kamar model = new Kamar();
        Kamar result = new Kamar();
        try {
            model.setId(kamarDto.getId());
            model.setTipe_kamar(kamarDto.getTipe_kamar());
            model.setFasilitas(kamarDto.getFasilitas());
            model.setHarga(kamarDto.getHarga());
            model.setKapasitas(kamarDto.getKapasitas());
            model.setStatus(kamarDto.getStatus());
            result = kamarRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean deleteDataKamar(int id) {
        Kamar model = kamarRepository.getById(id);
        kamarRepository.delete(model);
        return true;
    }


    @Override
    public Kamar updateDataKamar(KamarDto kamarDto) {
        Kamar model = new Kamar();
        Kamar result = new Kamar();
        try {
            model.setId(kamarDto.getId());
            model.setTipe_kamar(kamarDto.getTipe_kamar());
            model.setFasilitas(kamarDto.getFasilitas());
            model.setHarga(kamarDto.getHarga());
            model.setKapasitas(kamarDto.getKapasitas());
            model.setStatus(kamarDto.getStatus());
            result = kamarRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }



    @Override
    public List<Kamar> searchKamar(SearchDto searchDto) {
        List<Kamar> listData = kamarRepository.getKamar(searchDto.getCari());
        return listData;
    }
}
