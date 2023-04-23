package com.example.showinventoryservice.service;

import com.example.showinventoryservice.dto.v1.AddSeatDto;
import com.example.showinventoryservice.dto.v1.SeatDto;
import com.example.showinventoryservice.dto.v1.SeatReserveDto;
import com.example.showinventoryservice.dto.v1.response.SeatResponseDto;
import com.example.showinventoryservice.entity.Seat;
import com.example.showinventoryservice.entity.ShowTime;
import java.util.List;

public interface SeatService {
        SeatResponseDto reserveSeat(SeatReserveDto seat);
        SeatResponseDto bookSeat(SeatReserveDto seat);

        List<SeatDto> findByShowTime(String showTimeId);

        List<SeatDto> addSeat(AddSeatDto addSeatDto);
}
