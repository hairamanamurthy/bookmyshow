package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.repos.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    public void saveSeat(Seat seat){
        seatRepository.save(seat);
    }

}
