package com.company.hotel.services;

import com.company.hotel.dto.CheckInDto;
import com.company.hotel.dto.KamarDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.CheckIn;
import com.company.hotel.model.Kamar;
import com.company.hotel.model.Karyawan;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInServiceImplement implements CheckInService{
    @Autowired
    CheckInRepository checkInRepository;

    @Override
    public CheckInDto getCheckInById(int id) {
        CheckIn model = checkInRepository.getById(id);
        CheckInDto dto = new CheckInDto();

        dto.setId(model.getId());
        dto.setTipe_kamar(model.getTipe_kamar());
        dto.setFasilitas(model.getFasilitas());
        dto.setNama_karyawan(model.getNama_karyawan());
        dto.setNama_pengunjung(model.getNama_pengunjung());
        dto.setLama_menginap(model.getLama_menginap());
        return dto;
    }

    @Override
    public CheckIn insertCheckIn(CheckInDto checkInDto) {
        CheckIn model = new CheckIn();
        CheckIn result = new CheckIn();
        try {
            model.setId(checkInDto.getId());
            model.setTipe_kamar(checkInDto.getTipe_kamar());
            model.setFasilitas(checkInDto.getFasilitas());
            model.setNama_karyawan(checkInDto.getNama_karyawan());
            model.setNama_pengunjung(checkInDto.getNama_pengunjung());
            model.setLama_menginap(checkInDto.getLama_menginap());
            result = checkInRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public CheckIn insertCheckInUser2(CheckInDto checkInDto) {
        CheckIn model = new CheckIn();
        CheckIn result = new CheckIn();
        try {
            model.setId(checkInDto.getId());
            model.setTipe_kamar(checkInDto.getTipe_kamar());
            model.setFasilitas(checkInDto.getFasilitas());
            model.setNama_karyawan(checkInDto.getNama_karyawan());
            model.setNama_pengunjung(checkInDto.getNama_pengunjung());
            model.setLama_menginap(checkInDto.getLama_menginap());
            result = checkInRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean deleteDataCheckIn(int id) {
        CheckIn model= checkInRepository.getById(id);
        checkInRepository.delete(model);
        return true;
    }

    @Override
    public CheckIn updateDataCheckIn(CheckInDto checkInDto) {
        CheckIn model = new CheckIn();
        CheckIn result = new CheckIn();
        try {
            model.setId(checkInDto.getId());
            model.setTipe_kamar(checkInDto.getTipe_kamar());
            model.setFasilitas(checkInDto.getFasilitas());
            model.setNama_karyawan(checkInDto.getNama_karyawan());
            model.setNama_pengunjung(checkInDto.getNama_pengunjung());
            model.setLama_menginap(checkInDto.getLama_menginap());
            result = checkInRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<CheckIn> searchCheckIn(SearchDto searchDto) {
        List<CheckIn> listData = checkInRepository.getCheckIn(searchDto.getCari());
        return listData;
    }
}
