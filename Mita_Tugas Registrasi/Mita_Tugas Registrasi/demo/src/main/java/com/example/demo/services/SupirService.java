package com.example.demo.services;

import com.example.demo.dto.SearchDto;
import com.example.demo.dto.SupirDto;
import com.example.demo.models.Member;
import com.example.demo.models.Supir;

import java.util.List;

public interface SupirService {
    public Supir insertSupir(SupirDto supirDto);
    public Boolean deleteSupir(int id);
    public SupirDto getSupirById(int id);
    public Supir updateSupir(SupirDto supirDto);
    List<Supir> searchSupir(SearchDto searchDto);
}
