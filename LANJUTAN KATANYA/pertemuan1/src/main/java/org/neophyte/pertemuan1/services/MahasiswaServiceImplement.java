package org.neophyte.pertemuan1.services;

import lombok.Getter;
import lombok.Setter;
import org.neophyte.pertemuan1.Repositories.MahasiswaRepository;
import org.neophyte.pertemuan1.dto.MahasiswaDto;
import org.neophyte.pertemuan1.dto.SearchDto;
import org.neophyte.pertemuan1.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
public class MahasiswaServiceImplement implements MahasiswaService{
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Override
    public Mahasiswa insertDosen(MahasiswaDto mhsDto) {
        Mahasiswa model = new Mahasiswa();
        Mahasiswa result = new Mahasiswa();
        try {
            model.setNim(mhsDto.getNim());
            model.setNama(mhsDto.getNama());
            model.setAlamat(mhsDto.getAlamat());
            model.setJenisKelamin(mhsDto.getJenisKelamin());
            model.setJurusan(mhsDto.getJurusan());
            model.setNohp(mhsDto.getNohp());
            model.setEmail(mhsDto.getEmail());
            result = mahasiswaRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public MahasiswaDto getMahasiswaById(int id) {
        Mahasiswa model = mahasiswaRepository.getById(id);
        MahasiswaDto dto = new MahasiswaDto();

        dto.setId(model.getId());
        dto.setNim(model.getNim());
        dto.setNama(model.getNama());
        dto.setAlamat(model.getAlamat());
        dto.setJenisKelamin(model.getJenisKelamin());
        dto.setJurusan(model.getJurusan());
        dto.setNohp(model.getNohp());
        dto.setEmail(model.getEmail());
        return dto;

    }

    @Override
    public Mahasiswa updateMahasiswa(MahasiswaDto mhsDto) {
        Mahasiswa model = new Mahasiswa();
        Mahasiswa result = new Mahasiswa();
        try {
            model.setId(mhsDto.getId());
            model.setNim(mhsDto.getNim());
            model.setNama(mhsDto.getNama());
            model.setAlamat(mhsDto.getAlamat());
            model.setJenisKelamin(mhsDto.getJenisKelamin());
            model.setJurusan(mhsDto.getJurusan());
            model.setNohp(mhsDto.getNohp());
            model.setEmail(mhsDto.getEmail());
            result = mahasiswaRepository.save(model);
        }catch (Exception e){

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
