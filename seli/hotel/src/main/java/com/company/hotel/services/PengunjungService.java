package com.company.hotel.services;

import com.company.hotel.dto.MailResponseDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.dto.UserDto;
import com.company.hotel.model.Pengunjung;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PengunjungService{
    public PengunjungDto getPengunjungById(int id);
    public Pengunjung insertPengunjung(PengunjungDto pengunjungDto);
    public Pengunjung insertCheckInUser(PengunjungDto pengunjungDto);
    public boolean deleteDataPengunjung(int id);
    public Pengunjung updateDataPengunjung(PengunjungDto pengunjungDto);
    List<Pengunjung> searchPengunjung(SearchDto searchDto);
    public MailResponseDto sendEmail(PengunjungDto pengunjungDto);
}
