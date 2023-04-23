package com.booking.showinventoryservice.service;

import com.booking.showinventoryservice.dto.v1.AddSeatDto;
import com.booking.showinventoryservice.dto.v1.SeatDto;
import com.booking.showinventoryservice.dto.v1.SeatReserveDto;
import com.booking.showinventoryservice.dto.v1.response.SeatResponseDto;
import java.util.List;

public interface SeatService {
        SeatResponseDto reserveSeat(SeatReserveDto seat);
        SeatResponseDto bookSeat(SeatReserveDto seat);

        List<SeatDto> findByShowTime(String showTimeId);

        List<SeatDto> addSeat(AddSeatDto addSeatDto);
}
