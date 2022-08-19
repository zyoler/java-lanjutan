package com.example.demo.services;

import com.example.demo.dto.AnggotaDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.models.Anggota;
import com.example.demo.models.Member;
import com.example.demo.repositories.AnggotaRepository;
import com.example.demo.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnggotaServiceImplement implements AnggotaService {
    @Autowired
    AnggotaRepository anggotaRepository;

    @Override
    public Anggota insertAnggota(AnggotaDto anggotaDto) {
        Anggota model = new Anggota();
        Anggota result = new Anggota();
        try {
            model.setUsername(anggotaDto.getUsername());
            model.setPassword(anggotaDto.getPassword());
            model.setEmail(anggotaDto.getEmail());
            result = anggotaRepository.save(model);
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public Anggota updateAnggota(AnggotaDto anggotaDto){
        Anggota model = new Anggota();
        Anggota result = new Anggota();
        try {
            model.setId(anggotaDto.getId());
            model.setUsername(anggotaDto.getUsername());
            model.setEmail(anggotaDto.getEmail());
            model.setPassword(anggotaDto.getPassword());

            result = anggotaRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public AnggotaDto getAnggotaById(int id){
        Anggota model = anggotaRepository.getById(id);
        AnggotaDto dto = new AnggotaDto();

        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());

        return dto;
    }
}