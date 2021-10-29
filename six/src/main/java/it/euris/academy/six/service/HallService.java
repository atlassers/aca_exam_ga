package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.HallDto;

public interface HallService {
  public HallDto getById(Long id);

  public List<HallDto> getAll();

  public HallDto add(HallDto dto);

  public HallDto update(HallDto dto);

  public Boolean delete(Long id);
  
  //Other Methods
  
  public Boolean isHallFull (Long id);
  
  public HallDto getHallProfit(Long id);
  
  public HallDto createTicket(Long id);
 
  
}
