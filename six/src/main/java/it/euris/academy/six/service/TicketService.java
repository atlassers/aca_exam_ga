package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.TicketDto;

public interface TicketService {

  public TicketDto getById(Long id);

  public List<TicketDto> getAll();

  public TicketDto add(TicketDto dto);

  public TicketDto update(TicketDto dto);

  public Boolean delete(Long id);
}
