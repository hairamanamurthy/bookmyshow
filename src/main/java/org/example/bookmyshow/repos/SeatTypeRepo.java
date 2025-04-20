package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.SeatType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepo extends CrudRepository<SeatType, Long> {
}
