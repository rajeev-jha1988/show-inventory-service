package com.booking.showinventoryservice.service;

import com.booking.showinventoryservice.entity.ShowTime;

public interface ShowTimeService {

    ShowTime save(ShowTime showTime);

    ShowTime findByShowTimeId(String showTimeId);
}
