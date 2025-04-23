package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.SeatType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatTypeRepo extends CrudRepository<SeatType, Long> {
    public Optional<SeatType> findById(int id);
}
