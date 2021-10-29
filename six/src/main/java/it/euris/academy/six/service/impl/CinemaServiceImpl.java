package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.CinemaDto;
import it.euris.academy.six.data.model.Cinema;
import it.euris.academy.six.data.model.Hall;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.repository.CinemaRepository;
import it.euris.academy.six.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {
  
  @Autowired
  private CinemaRepository cinemaRepository;
  
  @Override
  public CinemaDto getById(Long id) {
    return cinemaRepository.findById(id).orElse(new Cinema()).toDto();
  }

  @Override
  public List<CinemaDto> getAll() {
    return cinemaRepository.findAll().stream().map(cinema->cinema.toDto()).collect(Collectors.toList());
  }

  @Override
  public CinemaDto add(CinemaDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return cinemaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public CinemaDto update(CinemaDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return cinemaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    cinemaRepository.deleteById(id);
    return cinemaRepository.findById(id).isEmpty();
  }

  @Override
  public CinemaDto getProfit(CinemaDto dto) {
    Cinema cinema = dto.toModel();
    List<Hall> halls = cinema.getHall();    
    double profit = cinema.getProfit();
    for (int i = 0; i<halls.size(); i++) {
      profit = profit + halls.get(i).getProfit();
    }
    cinema.setProfit(profit);
    return cinemaRepository.save(cinema).toDto();
  }


}
