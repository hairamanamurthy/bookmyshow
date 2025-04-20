package org.example.bookmyshow.services;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.repos.SeatTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatTypeService {
    @Autowired
    private SeatTypeRepo seatTypeRepo;

    public void saveSeatType(SeatType seatType) {
        seatTypeRepo.save(seatType);
    }

}
