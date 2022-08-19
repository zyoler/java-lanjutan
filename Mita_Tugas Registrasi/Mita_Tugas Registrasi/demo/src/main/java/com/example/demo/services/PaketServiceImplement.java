package com.example.demo.services;

import com.example.demo.dto.PaketDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Paket;
import com.example.demo.repositories.PaketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaketServiceImplement implements PaketService{
    @Autowired
    PaketRepository paketRepository;

    @Override
    public Paket insertPaket(PaketDto paketDto){
        Paket model = new Paket();
        Paket result = new Paket();
        try {
            model.setNama_paket(paketDto.getNama_paket());
            model.setDiskon(paketDto.getDiskon());
            model.setLama_rental(paketDto.getLama_rental());

            result = paketRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Boolean deletePaket(int id){
        Paket model = paketRepository.getById(id);
        paketRepository.delete(model);
        return true;
    }
    @Override
    public PaketDto getPaketById(int id){
        Paket model = paketRepository.getById(id);
        PaketDto dto = new PaketDto();

        dto.setId_paket(model.getId_paket());
        dto.setNama_paket(model.getNama_paket());
        dto.setDiskon(model.getDiskon());
        dto.setLama_rental(model.getLama_rental());
        return dto;
    }
    @Override
    public Paket updatePaket(PaketDto paketDto){
        Paket model = new Paket();
        Paket result = new Paket();
        try {
            model.setId_paket(paketDto.getId_paket());
            model.setNama_paket(paketDto.getNama_paket());
            model.setDiskon(paketDto.getDiskon());
            model.setLama_rental(paketDto.getLama_rental());

            result = paketRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Paket> searchPaket(SearchDto searchDto){
        List<Paket> listPaket = paketRepository.getPaket(searchDto.getCari());

        return listPaket;
    }
}
