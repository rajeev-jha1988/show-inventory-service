package com.booking.showinventoryservice.repository;

import com.booking.showinventoryservice.entity.Seat;
import com.booking.showinventoryservice.entity.ShowTime;
import com.booking.showinventoryservice.enums.SeatStatus;
import java.util.List;
import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Lock( LockModeType.PESSIMISTIC_WRITE )
    @QueryHints( { @QueryHint( name = "javax.persistence.lock.timeout", value = "3000" ) } )
    Seat findByRowAndColumnAndShowTimeAndSeatStatus(int row, int col, ShowTime showTime,SeatStatus seatStatus);

    @Lock( LockModeType.PESSIMISTIC_WRITE )
    @QueryHints( { @QueryHint( name = "javax.persistence.lock.timeout", value = "3000" ) } )
    List<Seat> findByIdInAndSeatStatus(List<Long> ids, SeatStatus seatStatus);

    List<Seat> findByShowTime(ShowTime showTime);
}
