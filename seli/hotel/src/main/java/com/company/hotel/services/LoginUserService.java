package com.company.hotel.services;

import com.company.hotel.model.Admin;
import com.company.hotel.model.User;

public interface LoginUserService {
    public User loginUser(String username, String password);
}
