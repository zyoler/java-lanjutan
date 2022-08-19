package com.company.hotel.services;

import com.company.hotel.model.Admin;
import com.company.hotel.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAdminServiceImplement implements LoginAdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin login(String username, String password){
        Admin admin = adminRepository.findAdminByUsernameAndPassword(username,password);
        return admin;
    }
}


