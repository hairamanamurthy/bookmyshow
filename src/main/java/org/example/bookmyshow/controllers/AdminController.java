package org.example.bookmyshow.controllers;

import org.example.bookmyshow.services.ShowSeatInitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ShowSeatInitializerService showSeatInitializerService;

    @PostMapping("/init-show-seats/{showId}")
    public ResponseEntity<String> initShowSeats(@PathVariable int showId) {
        showSeatInitializerService.initilizeShowSeatsForShow(showId);
        return ResponseEntity.ok("Successfully Initialized Show Seats");
    }
}
