package it.euris.academy.six.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.six.data.dto.CinemaDto;
import it.euris.academy.six.service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
  @Autowired
  CinemaService cinemaService;

  @GetMapping("/v6")
  public List<CinemaDto> getAll() {
      return cinemaService.getAll();
  }

  @GetMapping("/v6/{id}")
  public CinemaDto getById(@PathVariable("id") Long id) {
      return cinemaService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return cinemaService.delete(id);
  }

  @PostMapping("/v6")
  public CinemaDto insert(@RequestBody CinemaDto dto) {
      return cinemaService.add(dto);
  }

  @PutMapping("/v6")
  public CinemaDto update(@RequestBody CinemaDto dto) {
      return cinemaService.update(dto);
  }
  
}
