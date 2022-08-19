package com.company.hotel.services;

import com.company.hotel.dto.AdminDto;
import com.company.hotel.dto.KamarDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Admin;
import com.company.hotel.model.Kamar;

import java.util.List;

public interface KamarService {
    public KamarDto getKamarById(int id);
    public Kamar insertKamar(KamarDto kamarDto);
    public boolean deleteDataKamar(int id);
    public Kamar updateDataKamar(KamarDto kamarDto);
    List<Kamar> searchKamar(SearchDto searchDto);
}
