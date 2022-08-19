package com.example.demo.services;

import com.example.demo.dto.SearchDto;
import com.example.demo.dto.SupirDto;
import com.example.demo.models.Member;
import com.example.demo.models.Supir;
import com.example.demo.repositories.SupirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupirServiceImplement implements SupirService{
    @Autowired
    SupirRepository supirRepository;
    @Override
    public Supir insertSupir(SupirDto supirDto){
        Supir model = new Supir();
        Supir result = new Supir();
        try {
            model.setNama_supir(supirDto.getNama_supir());
            model.setAlamat(supirDto.getAlamat());
            model.setNo_telp(supirDto.getNo_telp());
            model.setHarga_perhari(supirDto.getHarga_perhari());
            model.setStatus(supirDto.getStatus());
            model.setFoto_supir(supirDto.getFoto_supir());

            result = supirRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public Boolean deleteSupir(int id){
        Supir model = supirRepository.getById(id);
        supirRepository.delete(model);
        return true;
    }
    @Override
    public SupirDto getSupirById(int id){
        Supir model = supirRepository.getById(id);
        SupirDto dto = new SupirDto();

        dto.setId_supir(model.getId_supir());
        dto.setNama_supir(model.getNama_supir());
        dto.setAlamat(model.getAlamat());
        dto.setNo_telp(model.getNo_telp());
        dto.setHarga_perhari(model.getHarga_perhari());
        dto.setStatus(model.getStatus());
        dto.setFoto_supir(model.getFoto_supir());

        return dto;
    }
    @Override
    public Supir updateSupir(SupirDto supirDto){
        Supir model = new Supir();
        Supir result = new Supir();
        try {
            model.setId_supir(supirDto.getId_supir());
            model.setNama_supir(supirDto.getNama_supir());
            model.setAlamat(supirDto.getAlamat());
            model.setNo_telp(supirDto.getNo_telp());
            model.setHarga_perhari(supirDto.getHarga_perhari());
            model.setStatus(supirDto.getStatus());
            model.setFoto_supir(supirDto.getFoto_supir());
            result = supirRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Supir> searchSupir(SearchDto searchDto){
        List<Supir> listSupir = supirRepository.getSupir(searchDto.getCari());

        return listSupir;
    }
}
