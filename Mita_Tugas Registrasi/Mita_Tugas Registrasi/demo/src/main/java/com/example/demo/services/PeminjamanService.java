package com.example.demo.services;

import com.example.demo.dto.PeminjamanDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Peminjaman;

import java.util.List;

public interface PeminjamanService {
    public Peminjaman insertPeminjaman(PeminjamanDto peminjamanDto);
    public PeminjamanDto getPeminjamanById(int id);
    public Peminjaman updatePeminjaman(PeminjamanDto peminjamanDto);
    List<Peminjaman> searchPeminjaman(SearchDto searchDto);
}
