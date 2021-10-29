package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
