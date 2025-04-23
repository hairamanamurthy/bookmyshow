package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType, Integer> {
}
