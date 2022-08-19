package com.company.hotel.services;

import com.company.hotel.model.Admin;
import com.company.hotel.model.User;
import com.company.hotel.repositories.UserRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImplement implements LoginUserService{
    @Autowired
    UserRepositori userRepositori;

    @Override
    public User loginUser(String username, String password) {
        User user = userRepositori.findUserByUsernameAndPassword(username,password);
        return user;
    }
}
