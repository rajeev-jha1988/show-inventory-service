package com.example.showinventoryservice.dto.v1;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSeatDto {

    @NotEmpty
    private String showTimeId;

    @NotEmpty
    private List<@Valid SeatInfo> seats;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SeatInfo{

        @NotNull
        Integer row;
        @NotNull
        Integer column;

    }

}
