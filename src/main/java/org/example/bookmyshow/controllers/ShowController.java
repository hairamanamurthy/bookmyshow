package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ShowRequestDto;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repos.MovieRepository;
import org.example.bookmyshow.repos.ScreenRepository;
import org.example.bookmyshow.repos.ShowRepository;
import org.example.bookmyshow.repos.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;

    @PostMapping
    public ResponseEntity<?> createShow(@RequestBody ShowRequestDto request) {

        try{
            Movie movie = movieRepository.findById(request.getMovieId())
                    .orElseThrow(() -> new RuntimeException("Movie not found"));
            Theatre theatre = theatreRepository.findById( request.getTheatreId())
                    .orElseThrow(()-> new RuntimeException("Theatre not found"));
            Screen screen = screenRepository.findById( request.getScreenId())
                    .orElseThrow(() -> new RuntimeException("Screen not found"));

            Date showTime = Date.from(LocalDateTime.parse(request.getShowTime())
                    .atZone(ZoneId.systemDefault()).toInstant());

            Show show=new Show();
            show.setTitle(request.getTitle());
            show.setTheatre(theatre);
            show.setScreen(screen);
            show.setMovie(movie);
            show.setShowTime(showTime);
            List<ShowSeat> showSeats=screen.getSeats().stream().map(seat -> {
                ShowSeat showSeat=new ShowSeat();
                showSeat.setSeat(seat);
                showSeat.setShow(show);
                showSeat.setStatus(ShowSeatStatus.AVAILABLE);
                return showSeat;
            }).toList();

            show.setShowSeats(showSeats);

            Show savedShow=showRepository.save(show);

            return ResponseEntity.ok("Show created successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected Error"+e.getMessage());
        }

    }
}
