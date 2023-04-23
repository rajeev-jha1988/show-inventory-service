package com.example.showinventoryservice.controller.v1;


import com.example.showinventoryservice.dto.v1.AddSeatDto;
import com.example.showinventoryservice.dto.v1.SeatDto;
import com.example.showinventoryservice.dto.v1.SeatReserveDto;
import com.example.showinventoryservice.dto.v1.response.SeatResponseDto;
import com.example.showinventoryservice.service.SeatService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
@Api
public class SeatInventoryController {

    private final SeatService seatService;

    public SeatInventoryController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping( path = "/add-seat" )
    public ResponseEntity<List<SeatDto>> addSeatForShow( @RequestBody @Valid AddSeatDto addSeatDto) {
        return ResponseEntity.ok( seatService.addSeat( addSeatDto ) );
    }


    @PutMapping( path = "/seat/reserve" )
    public ResponseEntity<SeatResponseDto> reserveSeat(
        @RequestBody @Valid SeatReserveDto seatReserveDto) {

        return ResponseEntity.ok( seatService.reserveSeat( seatReserveDto ) );
    }

    @PutMapping( path = "/seat/book" )
    public ResponseEntity<SeatResponseDto> bookSeat(
        @RequestBody @Valid SeatReserveDto seatReserveDto) {

        return ResponseEntity.ok( seatService.bookSeat( seatReserveDto ) );
    }

    @GetMapping( path = "/seat/show/{showTimeId}" )
    public ResponseEntity<List<SeatDto>> theatreDetail(@PathVariable(name = "showTimeId") String showTimeId ) {
        return ResponseEntity.ok( seatService.findByShowTime( showTimeId ) );
    }
}
