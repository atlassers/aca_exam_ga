package it.euris.academy.six.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.six.data.dto.MovieDto;
import it.euris.academy.six.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  @Autowired
  MovieService movieService;

  @GetMapping("/v6")
  public List<MovieDto> getAll() {
      return movieService.getAll();
  }

  @GetMapping("/v6/{id}")
  public MovieDto getById(@PathVariable("id") Long id) {
      return movieService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return movieService.delete(id);
  }

  @PostMapping("/v6")
  public MovieDto insert(@RequestBody MovieDto dto) {
      return movieService.add(dto);
  }

  @PutMapping("/v6")
  public MovieDto update(@RequestBody MovieDto dto) {
      return movieService.update(dto);
  }

}
