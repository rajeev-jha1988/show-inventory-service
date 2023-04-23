package com.booking.showinventoryservice.mapper;

import com.booking.showinventoryservice.dto.v1.SeatDto;
import com.booking.showinventoryservice.dto.v1.AddSeatDto.SeatInfo;
import com.booking.showinventoryservice.entity.Seat;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper( SeatMapper.class );
    Seat toSeat(SeatDto seatDto);
    List<SeatDto> toSeatDto(List<Seat> seats);
    List<Seat> toSeat(List<SeatInfo> seats);
}
