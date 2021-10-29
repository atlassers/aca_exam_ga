package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
