package com.example.demo.services;

import com.example.demo.dto.MahasiswaDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    public MahasiswaDto getMahasiswaById(int id);
    public Mahasiswa insertMahasiswa (MahasiswaDto mhsDto);
    public Mahasiswa updateMahasiswa (MahasiswaDto mhsDto);
    public boolean deleteMahasiswa(int id);
    List<Mahasiswa> searchMahasiswa (SearchDto searchDto);
}
