package com.company.hotel.services;

import com.company.hotel.dto.AdminDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Admin;
import com.company.hotel.model.Pengunjung;

import java.util.List;

public interface AdminService {
    public AdminDto getAdminById(int id);
    public Admin insertAdmin(AdminDto adminDto);
    public boolean deleteDataAdmin(int id);
    public Admin updateDataAdmin(AdminDto adminDto);
    List<Admin> searchAdmin(SearchDto searchDto);
}
