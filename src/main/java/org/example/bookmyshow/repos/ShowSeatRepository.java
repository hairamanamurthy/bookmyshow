package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.Show;
import org.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    public List<ShowSeat> findByShowId(int showId);
}
