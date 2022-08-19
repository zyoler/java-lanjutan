package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.Repositories.MahasiswaRepository;
import org.neophyte.pertemuan1.helper.ExcelHelper;
import org.neophyte.pertemuan1.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public void save(MultipartFile file){
        try{
            List<Mahasiswa> mahasiswa = ExcelHelper.excelToMahasiswa(file.getInputStream());
            mahasiswaRepository.saveAll(mahasiswa);

        }catch (IOException e){
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Mahasiswa> getAllMahasiswa(){
        return mahasiswaRepository.findAll();
    }
}

