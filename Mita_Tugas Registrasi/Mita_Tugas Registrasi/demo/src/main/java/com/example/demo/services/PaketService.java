package com.example.demo.services;

import com.example.demo.dto.PaketDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Paket;

import java.util.List;

public interface PaketService {
    public Paket insertPaket(PaketDto paketDto);
    public Boolean deletePaket(int id);
    public PaketDto getPaketById(int id);
    public Paket updatePaket(PaketDto paketDto);
    List<Paket> searchPaket(SearchDto searchDto);
}
