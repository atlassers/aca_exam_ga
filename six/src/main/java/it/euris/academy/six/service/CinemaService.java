package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.CinemaDto;


public interface CinemaService {

  public CinemaDto getById(Long id);

  public List<CinemaDto> getAll();

  public CinemaDto add(CinemaDto dto);

  public CinemaDto update(CinemaDto dto);

  public Boolean delete(Long id);
  
  public CinemaDto getProfit(CinemaDto dto);
  
}
