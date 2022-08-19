package com.company.hotel.services;

import com.company.hotel.dto.MailResponseDto;
import com.company.hotel.dto.UserDto;
import com.company.hotel.model.User;

public interface UserService {
    public User insertUser(UserDto userDto);
    public MailResponseDto sendEmail(UserDto userDto);
}
