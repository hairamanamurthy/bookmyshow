package org.example.bookmyshow.controllers;

import jakarta.validation.Valid;
import org.example.bookmyshow.models.Region;
import org.example.bookmyshow.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping
    public ResponseEntity<String> createRegions(@Valid @RequestBody Region region) {
        regionService.save(region);
        return ResponseEntity.ok("Region created successfully");
    }

}
