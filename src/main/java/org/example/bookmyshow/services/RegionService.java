package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Region;
import org.example.bookmyshow.repos.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public void save(Region region) {
        regionRepository.save(region);
    }
}
