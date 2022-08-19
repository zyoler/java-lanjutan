package com.company.hotel.services;

import com.company.hotel.dto.KaryawanDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.KaryawanRepository;
import com.company.hotel.repositories.PengunjungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaryawanServiceImplement implements KaryawanService{
    @Autowired
    KaryawanRepository karyawanRepository;
    @Override
    public KaryawanDto getKaryawanById(int id) {
        Karyawan model = karyawanRepository.getById(id);
        KaryawanDto dto = new KaryawanDto();

        dto.setId(model.getId());
        dto.setNo_ktp(model.getNo_ktp());
        dto.setNama_karyawan(model.getNama_karyawan());
        dto.setJenis_kelamin(model.getJenis_kelamin());
        dto.setAlamat(model.getAlamat());
        dto.setEmail(model.getEmail());
        dto.setNo_telp(model.getNo_telp());
        return dto;
    }

    @Override
    public Karyawan insertKaryawan(KaryawanDto karyawanDto) {
        Karyawan model = new Karyawan();
        Karyawan result = new Karyawan();
        try {
            model.setNo_ktp(karyawanDto.getNo_ktp());
            model.setNama_karyawan(karyawanDto.getNama_karyawan());
            model.setJenis_kelamin(karyawanDto.getJenis_kelamin());
            model.setAlamat(karyawanDto.getAlamat());
            model.setNo_telp(karyawanDto.getNo_telp());
            model.setEmail(karyawanDto.getEmail());
            result = karyawanRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean deleteDataKaryawan(int id) {
        Karyawan model = karyawanRepository.getById(id);
        karyawanRepository.delete(model);
        return true;
    }

    @Override
    public Karyawan updateDataKaryawan(KaryawanDto karyawanDto) {
        Karyawan model = new Karyawan();
        Karyawan result = new Karyawan();
        try {
            model.setId(karyawanDto.getId());
            model.setNo_ktp(karyawanDto.getNo_ktp());
            model.setNama_karyawan(karyawanDto.getNama_karyawan());
            model.setJenis_kelamin(karyawanDto.getJenis_kelamin());
            model.setAlamat(karyawanDto.getAlamat());
            model.setNo_telp(karyawanDto.getNo_telp());
            model.setEmail(karyawanDto.getEmail());
            result = karyawanRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Karyawan> searchKaryawan(SearchDto searchDto) {
        List<Karyawan> listData = karyawanRepository.getKaryawan(searchDto.getCari());
        return listData;
    }
}
