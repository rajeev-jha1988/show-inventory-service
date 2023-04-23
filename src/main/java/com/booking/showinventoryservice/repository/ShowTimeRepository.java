package com.example.showinventoryservice.repository;

import com.example.showinventoryservice.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime,Long> {
    ShowTime findByShowTimeId(String showTimeId);
}
