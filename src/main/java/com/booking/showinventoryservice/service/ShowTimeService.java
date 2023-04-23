package com.example.showinventoryservice.service;

import com.example.showinventoryservice.entity.ShowTime;

public interface ShowTimeService {

    ShowTime save(ShowTime showTime);

    ShowTime findByShowTimeId(String showTimeId);
}
