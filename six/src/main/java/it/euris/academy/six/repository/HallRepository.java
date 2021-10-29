package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {

}
