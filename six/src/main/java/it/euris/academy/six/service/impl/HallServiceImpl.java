package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JToggleButton.ToggleButtonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.HallDto;
import it.euris.academy.six.data.model.Hall;
import it.euris.academy.six.data.model.User;
import it.euris.academy.six.exception.HallFullException;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.exception.IdMustNotBeNullException;
import it.euris.academy.six.repository.HallRepository;
import it.euris.academy.six.repository.TicketRepository;
import it.euris.academy.six.repository.UserRepository;
import it.euris.academy.six.service.HallService;
import it.euris.academy.six.service.TicketService;
import it.euris.academy.six.service.UserService;


@Service
public class HallServiceImpl implements HallService{

  @Autowired
  private HallRepository hallRepository;  
    
  @Autowired
  private UserService userService;
  
  
  @Override
  public HallDto getById(Long id) {
    return hallRepository.findById(id).orElse(new Hall()).toDto();
  }

  @Override
  public List<HallDto> getAll() {
    return hallRepository.findAll().stream().map(hall->hall.toDto()).collect(Collectors.toList());
  }

  @Override
  public HallDto add(HallDto dto) {
    if (dto.getIdHall()!=null) {
      throw new IdMustBeNullException();
    }
    Hall modelHall=dto.toModel();
    Hall savHall=hallRepository.save(modelHall);
    return savHall.toDto();
  }

  @Override
  public HallDto update(HallDto dto) {
    if (dto.getIdHall()==null) {
      throw new IdMustNotBeNullException();
    }
    return hallRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    hallRepository.deleteById(id);
    return hallRepository.findById(id).isEmpty();
  }  

  @Override
  public Boolean isHallFull(Long id) {
    Hall hall = getById(id).toModel(); 
    return (hall.getCapacity()> hall.getUsers().size());
  }

  @Override
  public HallDto getHallProfit(Long id) {
    Hall hall = getById(id).toModel();
    Double profit = hall.getProfit();
    for (int i = 0; i<hall.getUsers().size(); i++ ) {
      List<User> users = hall.getUsers();
      profit = profit + users.get(i).getTicket().getPrice();
    }
    hall.setProfit(profit);
    return hallRepository.save(hall).toDto();
  }

  @Override
  public HallDto createTicket(Long id) {       
    if (isHallFull(id)) {
        throw new HallFullException ();
    }
    userService.add(null);
   return null;
  }  
    
  

}
