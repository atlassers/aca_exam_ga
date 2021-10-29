package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
