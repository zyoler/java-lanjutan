package com.example.demo.services;

import com.example.demo.dto.MahasiswaDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.Mahasiswa;
import com.example.demo.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaServiceImplement implements MahasiswaService {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Override
    public MahasiswaDto getMahasiswaById(int id){
        Mahasiswa model = mahasiswaRepository.getById(id);
        MahasiswaDto dto = new MahasiswaDto();
        dto.setId(model.getId());
        dto.setNama(model.getNama());
        dto.setNim(model.getNim());
        dto.setJk(model.getJk());
        dto.setJurusan(model.getJurusan());
        dto.setNohp(model.getNohp());
        dto.setEmail(model.getEmail());
        dto.setAlamat(model.getAlamat());
        return dto;
    }

    @Override
    public Mahasiswa insertMahasiswa(MahasiswaDto mhsDto) {
        Mahasiswa model = new Mahasiswa();
        Mahasiswa result = new Mahasiswa();

        try{
            model.setNim(mhsDto.getNim());
            model.setNama(mhsDto.getNama());
            model.setJk(mhsDto.getJk());
            model.setJurusan(mhsDto.getJurusan());
            model.setNohp(mhsDto.getNohp());
            model.setEmail(mhsDto.getEmail());
            model.setAlamat(mhsDto.getAlamat());

            result = mahasiswaRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Mahasiswa updateMahasiswa(MahasiswaDto mhsDto) {
        Mahasiswa model = new Mahasiswa();
        Mahasiswa result = new Mahasiswa();

        try{
            model.setId(mhsDto.getId());
            model.setNim(mhsDto.getNim());
            model.setNama(mhsDto.getNama());
            model.setJk(mhsDto.getJk());
            model.setJurusan(mhsDto.getJurusan());
            model.setNohp(mhsDto.getNohp());
            model.setEmail(mhsDto.getEmail());
            model.setAlamat(mhsDto.getAlamat());

            result = mahasiswaRepository.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteMahasiswa(int id) {
        Mahasiswa model = mahasiswaRepository.getById(id);
        mahasiswaRepository.delete(model);
        return true;
    }

    @Override
    public List<Mahasiswa> searchMahasiswa(SearchDto searchDto) {
        List<Mahasiswa> listData = mahasiswaRepository.getMahasiswa(searchDto.getCari());
        return listData;
    }

}
