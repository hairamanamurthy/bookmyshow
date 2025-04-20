package org.example.bookmyshow.controllers;

import jakarta.validation.Valid;
import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping
    public ResponseEntity<String> saveSeat(@Valid @RequestBody Seat seat) {
        seatService.saveSeat(seat);
        return ResponseEntity.ok("Seat Saved");
    }
}
