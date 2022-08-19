package com.example.demo.services.implement;

import com.example.demo.dto.JualDto;
import com.example.demo.models.JualModels;
import com.example.demo.repositories.JualRepository;
import com.example.demo.services.JualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JualServiceImplement implements JualService {
    @Autowired
    JualRepository jualRepository;

    @Override
    public JualModels inputTransaksi (JualDto jualDto){
        JualModels models = new JualModels();
        JualModels result = new JualModels();

        try{
            models.setReferal(jualDto.getReferal());
            models.setTglbeli(jualDto.getTglbeli());
            models.setBanyak(jualDto.getBanyak());
            models.setHargajual(jualDto.getHargajual());
            models.setNamaobat(jualDto.getNamaobat());
            models.setNamapembeli(jualDto.getNamapembeli());
            models.setSubtotal(jualDto.getSubtotal());

            result = jualRepository.save(models);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
