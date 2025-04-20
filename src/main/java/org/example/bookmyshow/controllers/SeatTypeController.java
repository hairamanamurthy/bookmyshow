package org.example.bookmyshow.controllers;

import jakarta.validation.Valid;
import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.services.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seatTypes")
    public class SeatTypeController {
    @Autowired
    private SeatTypeService seatTypeService;

    @PostMapping
    public ResponseEntity<String> saveSeatTypes(@Valid @RequestBody SeatType seatType) {
        seatTypeService.saveSeatType(seatType);
        return ResponseEntity.ok("SeatType created successfully");
    }
}
