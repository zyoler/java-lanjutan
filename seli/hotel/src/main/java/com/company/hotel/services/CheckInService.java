package com.company.hotel.services;

import com.company.hotel.dto.CheckInDto;
import com.company.hotel.dto.KamarDto;
import com.company.hotel.dto.SearchDto;
import com.company.hotel.model.CheckIn;
import com.company.hotel.model.Kamar;

import java.util.List;

public interface CheckInService {
    public CheckInDto getCheckInById(int id);
    public CheckIn insertCheckIn(CheckInDto checkInDto);
    public CheckIn insertCheckInUser2(CheckInDto checkInDto);
    public boolean deleteDataCheckIn(int id);
    public CheckIn updateDataCheckIn(CheckInDto checkInDto);
    List<CheckIn> searchCheckIn(SearchDto searchDto);
}
