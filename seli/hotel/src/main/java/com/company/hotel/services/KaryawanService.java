package com.company.hotel.services;

import com.company.hotel.dto.KaryawanDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KaryawanService {
    public KaryawanDto getKaryawanById(int id);
    public Karyawan insertKaryawan(KaryawanDto karyawanDto);
    public boolean deleteDataKaryawan(int id);
    public Karyawan updateDataKaryawan(KaryawanDto karyawanDto);
    List<Karyawan> searchKaryawan(SearchDto searchDto);
}
