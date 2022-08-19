package com.company.hotel.services;

import com.company.hotel.model.Admin;

public interface LoginAdminService {
    public Admin login(String username, String password);
}