package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ShowSeatTypeDto;
import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeatType;
import org.example.bookmyshow.repos.SeatTypeRepo;
import org.example.bookmyshow.repos.ShowRepository;
import org.example.bookmyshow.repos.ShowSeatRepository;
import org.example.bookmyshow.repos.ShowSeatTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showsettypes")
public class ShowSeatTypeController {
    @Autowired
    private ShowSeatTypeRepo showSeatTypeRepo;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatTypeRepo seatTypeRepo;

    @PostMapping
    public ResponseEntity<String> addShowSeatType(@RequestBody ShowSeatTypeDto request)
    {
        try{
            Show show=showRepository.findById(request.getShowId())
                    .orElseThrow(() -> new RuntimeException("Show not found"));
            SeatType seatType=seatTypeRepo.findById(request.getSeatTypeId())
                    .orElseThrow(() -> new RuntimeException("SeatType not found"));

            ShowSeatType showSeatType=new ShowSeatType();
            showSeatType.setShow(show);
            showSeatType.setSeatType(seatType);
            showSeatType.setPrice(request.getPrice());
            showSeatTypeRepo.save(showSeatType);
            return ResponseEntity.ok("Show Seat Type Added");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error: "+e.getMessage());
        }
    }
}
