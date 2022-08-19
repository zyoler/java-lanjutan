package com.example.demo.services;

import com.example.demo.models.Anggota;
import com.example.demo.repositories.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService{
    @Autowired
    AnggotaRepository anggotaRepository;

    @Override
    public Anggota login(String username, String password){
        Anggota anggota = anggotaRepository.findAdminByUsernameAndPassword(username,password);
        return anggota;
    }
}
