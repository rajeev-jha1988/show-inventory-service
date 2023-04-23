package com.booking.showinventoryservice.service.v1;

import com.booking.showinventoryservice.entity.Auditorium;
import com.booking.showinventoryservice.repository.AuditoriumRepository;
import com.booking.showinventoryservice.service.AuditoriumService;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        return auditoriumRepository.save( auditorium );
    }
}
