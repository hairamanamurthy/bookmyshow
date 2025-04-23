package org.example.bookmyshow.controllers;

import jakarta.validation.Valid;
import org.example.bookmyshow.dtos.BookingTicketRequestDTO;
import org.example.bookmyshow.dtos.BookingTicketResponseDTO;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Profile("bookings")
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingTicketRequestDTO request) {
        //BookingTicketResponseDTO response = new BookingTicketResponseDTO();
        System.out.println("Entered in BookingController");
        try{
            Booking booking=bookingService.bookTicket(request);
            return ResponseEntity.ok(booking);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error"+ex.getMessage());
        }

    }
    //public bookingTicket()
}
