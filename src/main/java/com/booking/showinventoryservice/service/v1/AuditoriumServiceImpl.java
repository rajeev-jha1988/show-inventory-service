package com.example.showinventoryservice.service.v1;

import com.example.showinventoryservice.entity.Auditorium;
import com.example.showinventoryservice.repository.AuditoriumRepository;
import com.example.showinventoryservice.service.AuditoriumService;
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
