package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.ShowSeatStatus;
import org.example.bookmyshow.repos.SeatRepository;
import org.example.bookmyshow.repos.ShowRepository;
import org.example.bookmyshow.repos.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowSeatInitializerService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;


    //Initializing showseats for show
    public void initilizeShowSeatsForShow(int showId) {

        //Get show obj based on show id
        Show show=showRepository.findById(showId)
                .orElseThrow(()-> new RuntimeException("Show not found") );

        //Get all seats
        List<Seat> allSeats=seatRepository.findAll();

        //Get existing show seats for this show
        List<ShowSeat> existingShowSeats=showSeatRepository.findByShowId(showId);

        //create a set of existing seat ids for this show
        Set<Integer> existingSeatsIds=existingShowSeats.stream()
                .map(ss -> ss.getId())
                .collect(Collectors.toSet());

        List<ShowSeat> newShowSeats= new ArrayList<>();

        for(Seat seat:allSeats){
            if(!existingSeatsIds.contains(seat.getId())){
                ShowSeat tempShowSeat=new ShowSeat();
                tempShowSeat.setShow(show);
                tempShowSeat.setSeat(seat);
                tempShowSeat.setStatus(ShowSeatStatus.AVAILABLE);
                tempShowSeat.setBlockedAt(null);
                newShowSeats.add(tempShowSeat);
            }
        }

        if(!newShowSeats.isEmpty()){
            showSeatRepository.saveAll(newShowSeats);
            System.out.println("Inserted "+ newShowSeats.size()+" new seats into the show");
        }else{
            System.out.println("No new seats into the show");
        }
    }
}
