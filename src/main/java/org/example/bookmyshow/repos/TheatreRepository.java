package org.example.bookmyshow.repos;

import org.example.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    public Optional<Theatre> findByName(String name);
    public Optional<Theatre> findById(int theatreId);
}
