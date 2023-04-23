package com.example.showinventoryservice.dto.v1;


import com.example.showinventoryservice.entity.Seat;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatReserveDto {

    List<SeatDto> seats;
    private String showTimeId;
    @Data
    public static class SeatDto{
        private int row;
        private int column;
    }


}
