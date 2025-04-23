package org.example.bookmyshow.services;

import org.example.bookmyshow.dtos.BookingTicketRequestDTO;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;





    public Booking bookTicket(BookingTicketRequestDTO requestDTO) {
        //1.validate user
        User user=userRepository.findById(requestDTO.getUserId())
                .orElseThrow((()-> new RuntimeException("Invalid user") ));
        //2.validate showid
        Show show=showRepository.findById(requestDTO.getShowId())
                .orElseThrow((()-> new RuntimeException("Invalid show") ));
        //System.out.println(show.toString());
        //3.Fetch showSeats
        List<ShowSeat> selectedSeats=showSeatRepository.findAllById(requestDTO.getSeatList());

        if(selectedSeats.isEmpty()){
            throw new RuntimeException("No valid seats selected");
        }

        //4.validate each seat
        for(ShowSeat seat:selectedSeats){
            if(seat.getShow().getId()!=show.getId()){
                throw new RuntimeException("Seat " + seat.getId() + " does not belong to Show " + show.getId());
            }

            if(seat.getStatus()!= ShowSeatStatus.AVAILABLE){
                throw new RuntimeException("Seat " + seat.getSeat().getSeatName() + " is not available");
            }
        }
        //5.Block seats
        Date now=new Date();
        for(ShowSeat seat:selectedSeats){
            seat.setStatus(ShowSeatStatus.BOOKED);
            seat.setBlockedAt(now);
        }
        showSeatRepository.saveAll(selectedSeats);
        //6. calculat price

        //7.create booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(selectedSeats);
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.SUCCESS);

        return bookingRepository.save(booking);
    }
}
