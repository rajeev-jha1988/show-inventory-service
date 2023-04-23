package com.booking.showinventoryservice.dto.v1.response;


import com.booking.showinventoryservice.dto.v1.SeatDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatResponseDto {
    private List<SeatDto> seats;

}
