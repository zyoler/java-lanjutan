package com.example.demo.services;

import com.example.demo.models.Anggota;

public interface LoginService {
    public Anggota login(String username, String password);
}
