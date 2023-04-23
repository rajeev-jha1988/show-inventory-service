package com.booking.showinventoryservice.service.v1;

import com.booking.showinventoryservice.dto.v1.AddSeatDto;
import com.booking.showinventoryservice.dto.v1.SeatDto;
import com.booking.showinventoryservice.dto.v1.response.SeatResponseDto;
import com.booking.showinventoryservice.entity.Seat;
import com.booking.showinventoryservice.entity.ShowTime;
import com.booking.showinventoryservice.enums.SeatStatus;
import com.booking.showinventoryservice.mapper.SeatMapper;
import com.booking.showinventoryservice.repository.SeatRepository;
import com.booking.showinventoryservice.service.SeatService;
import com.booking.showinventoryservice.service.ShowTimeService;
import com.booking.showinventoryservice.dto.v1.SeatReserveDto;
import com.booking.showinventoryservice.exceptions.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    private final ShowTimeService showTimeService;

    public SeatServiceImpl(SeatRepository seatRepository, ShowTimeService showTimeService) {
        this.seatRepository = seatRepository;
        this.showTimeService = showTimeService;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SeatResponseDto reserveSeat(SeatReserveDto seatReserveDto) {

        ShowTime showTime = showTimeService.findByShowTimeId( seatReserveDto.getShowTimeId() );

        List<Seat> byIdIn = seatReserveDto.getSeats().stream().map( seatDto ->
            seatRepository.findByRowAndColumnAndShowTimeAndSeatStatus( seatDto.getRow(), seatDto.getColumn(),
                showTime, SeatStatus.AVAILABLE )
        ).collect( Collectors.toList() );


        validateSeatIds( seatReserveDto, byIdIn );

        byIdIn.forEach( seat -> seat.setSeatStatus( SeatStatus.RESERVED ) );

        seatRepository.saveAll( byIdIn );

        return SeatResponseDto.builder()
            .seats( SeatMapper.INSTANCE.toSeatDto( byIdIn ) )
            .build();
    }

    private static void validateSeatIds(SeatReserveDto seatReserveDto, List<Seat> byIdIn) {
        if( byIdIn.isEmpty() ){
            throw new NotFoundException();
        }

        if( byIdIn.size()!= seatReserveDto.getSeats().size() ){
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SeatResponseDto bookSeat(SeatReserveDto seatReserveDto) {

        ShowTime showTime = showTimeService.findByShowTimeId( seatReserveDto.getShowTimeId() );

        List<Seat> byIdIn = seatReserveDto.getSeats().stream().map( seatDto ->
            seatRepository.findByRowAndColumnAndShowTimeAndSeatStatus( seatDto.getRow(), seatDto.getColumn(),
                showTime,SeatStatus.RESERVED )
        ).collect( Collectors.toList() );


        validateSeatIds( seatReserveDto, byIdIn );

        byIdIn.forEach( seat -> seat.setSeatStatus( SeatStatus.BOOKED ) );

        seatRepository.saveAll( byIdIn );
        return SeatResponseDto.builder()
            .seats( SeatMapper.INSTANCE.toSeatDto( byIdIn ) )
            .build();

    }

    @Override
    public List<SeatDto> findByShowTime(String showTimeId) {
        ShowTime showTime = showTimeService.findByShowTimeId( showTimeId );
        List<Seat> byShowTime = seatRepository.findByShowTime( showTime );
        return SeatMapper.INSTANCE.toSeatDto( byShowTime );
    }

    @Override
    public List<SeatDto> addSeat(AddSeatDto addSeatDto) {
        ShowTime showTime = showTimeService.findByShowTimeId( addSeatDto.getShowTimeId() );
        // validate if show seat is already exist

        List<Seat> seats = SeatMapper.INSTANCE.toSeat( addSeatDto.getSeats() );
        seats.forEach( seat -> {
            seat.setSeatStatus( SeatStatus.AVAILABLE );
            seat.setShowTime( showTime );
            }
        );
        seatRepository.saveAll( seats );

        return SeatMapper.INSTANCE.toSeatDto( seats );
    }
}
