package com.example.demo.services;

import com.example.demo.helper.ExcelHelper;
import com.example.demo.models.Mahasiswa;
import com.example.demo.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ExcelService {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public void save(MultipartFile file) {
        try{
            List<Mahasiswa> mahasiswas = ExcelHelper.excelToMahasiswa(file.getInputStream());
            mahasiswaRepository.saveAll(mahasiswas);
        } catch (Exception e){
            throw new RuntimeException("Fail to store excel data: " + e.getMessage());
        }
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }
}
