package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {

}
