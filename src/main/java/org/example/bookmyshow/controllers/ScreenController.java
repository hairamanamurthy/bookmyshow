package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ScreenRequestDto;
import org.example.bookmyshow.models.Screen;
import org.example.bookmyshow.models.Theatre;
import org.example.bookmyshow.repos.ScreenRepository;
import org.example.bookmyshow.repos.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screens")
public class ScreenController {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ScreenRepository screenRepository;
    public ScreenController(TheatreRepository theatreRepository, ScreenRepository screenRepository) {
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
    }
    @PostMapping
    public ResponseEntity<?> saveScreen(@RequestBody ScreenRequestDto request) {

        try {
            Theatre theatre=theatreRepository.findByName(request.getTheatreName())
                    .orElseThrow(() -> new RuntimeException("There is no theatre with that name"));
            Screen screen = new Screen();
            screen.setName(request.getScreenName());
            screen.setTheatre(theatre);

            Screen savedScreen = screenRepository.save(screen);
            return ResponseEntity.ok(savedScreen);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Error"+ e.getMessage());
        }
    }
}
