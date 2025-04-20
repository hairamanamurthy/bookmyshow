package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.repos.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoiveService {
    @Autowired
    private MovieRepository movieRepository;
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
