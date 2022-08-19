package com.example.demo.Service;

import com.example.demo.Dto.MahasiswaDto;
import com.example.demo.Dto.SearchDto;
import com.example.demo.Model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    public Mahasiswa insertDosen(MahasiswaDto mhsDto);
    public MahasiswaDto getMahasiswaById(int id);
    public Mahasiswa updateMahasiswa(MahasiswaDto mhsDto);
    public boolean deleteMahasiswa(int id);
    List<Mahasiswa> searchMahasiswa(SearchDto searchDto);
}
