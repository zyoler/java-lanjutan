package com.example.demo.services;

import com.example.demo.dto.MobilDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Member;
import com.example.demo.models.Mobil;

import java.util.List;

public interface MobilService {
    public Mobil insertMobil(MobilDto mobilDto);
    public Boolean deleteMobil(int id);
    public MobilDto getMobilById(int id);
    public Mobil updateMobil(MobilDto mobilDto);
    List<Mobil> searchMobil(SearchDto searchDto);
}
