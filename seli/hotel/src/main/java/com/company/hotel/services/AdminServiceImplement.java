package com.company.hotel.services;

import com.company.hotel.dto.AdminDto;
import com.company.hotel.dto.PengunjungDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.Admin;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImplement implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminDto getAdminById(int id) {
        Admin model = adminRepository.getById(id);
        AdminDto dto = new AdminDto();

        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());

        return  dto;
    }

    @Override
    public Admin insertAdmin(AdminDto adminDto) {
        Admin model = new Admin();
        Admin result = new Admin();
        try{
            model.setUsername(adminDto.getUsername());
            model.setPassword(adminDto.getPassword());
            result = adminRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean deleteDataAdmin(int id) {
        Admin model = adminRepository.getById(id);
        adminRepository.delete(model);
        return true;
    }

    @Override
    public Admin updateDataAdmin(AdminDto adminDto) {
        Admin model = new Admin();
        Admin result = new Admin();
        try{
            model.setId(adminDto.getId());
            model.setUsername(adminDto.getUsername());
            model.setPassword(adminDto.getPassword());
            result = adminRepository.save(model);
        }catch (Exception e){

        }
        return result;

    }

    @Override
    public List<Admin> searchAdmin(SearchDto searchDto) {
        List<Admin> listData = adminRepository.getAdmin(searchDto.getCari());
        return listData;
    }


}
