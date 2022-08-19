package com.example.demo.services;

import com.example.demo.dto.AnggotaDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.models.Anggota;
import com.example.demo.models.Member;

public interface AnggotaService {
    public Anggota insertAnggota(AnggotaDto anggotaDto);
    public AnggotaDto getAnggotaById(int id);
    public Anggota updateAnggota(AnggotaDto anggotaDto);
}
