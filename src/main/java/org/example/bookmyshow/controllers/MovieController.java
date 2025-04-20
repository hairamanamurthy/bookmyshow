package org.example.bookmyshow.controllers;

import jakarta.validation.Valid;
import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.repos.MovieRepository;
import org.example.bookmyshow.services.MoiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MoiveService movieService;
    @PostMapping
    public ResponseEntity<String> createMovie(@Valid @RequestBody Movie movie){
        movieService.save(movie);
        return ResponseEntity.ok("Movie created sucessfully");
    }
}
