package com.booking.showinventoryservice.service.v1;

import com.booking.showinventoryservice.entity.ShowTime;
import com.booking.showinventoryservice.repository.ShowTimeRepository;
import com.booking.showinventoryservice.service.ShowTimeService;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    private final ShowTimeRepository showTimeRepository;

    public ShowTimeServiceImpl(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    @Override
    public ShowTime save(ShowTime showTime) {
        return showTimeRepository.save( showTime );
    }

    @Override
    public ShowTime findByShowTimeId(String showTimeId) {
        return null;
    }
}
