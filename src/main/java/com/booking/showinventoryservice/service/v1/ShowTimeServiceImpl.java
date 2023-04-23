package com.example.showinventoryservice.service.v1;

import com.example.showinventoryservice.entity.ShowTime;
import com.example.showinventoryservice.repository.ShowTimeRepository;
import com.example.showinventoryservice.service.ShowTimeService;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeServiceImpl implements ShowTimeService  {

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
