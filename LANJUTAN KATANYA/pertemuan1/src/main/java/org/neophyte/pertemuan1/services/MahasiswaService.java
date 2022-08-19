package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.dto.MahasiswaDto;
import org.neophyte.pertemuan1.dto.SearchDto;
import org.neophyte.pertemuan1.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    public Mahasiswa insertDosen(MahasiswaDto mhsDto);
    public MahasiswaDto getMahasiswaById(int id);
    public  Mahasiswa updateMahasiswa(MahasiswaDto mhsDto);
    public boolean deleteMahasiswa(int id);
    List<Mahasiswa> searchMahasiswa(SearchDto searchDto);
}
