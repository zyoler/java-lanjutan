package org.neophyte.pertemuan1.services;

import org.neophyte.pertemuan1.Repositories.AdminRepository;
import org.neophyte.pertemuan1.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements loginService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin login(String username, String password){
        Admin admin = adminRepository.findAdminByUsernameAndPassword(username,password);
        return admin;
    }
}
