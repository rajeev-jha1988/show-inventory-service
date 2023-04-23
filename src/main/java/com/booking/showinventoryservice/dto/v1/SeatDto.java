package com.example.showinventoryservice.dto.v1;

import com.example.showinventoryservice.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private Long id;

    private int row;

    private int column;

    private SeatStatus seatStatus;
}
