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
import it.euris.academy.six.data.dto.HallDto;
import it.euris.academy.six.service.HallService;

@RestController
@RequestMapping("/halls")
public class HallController {
  @Autowired
  HallService hallService;

  @GetMapping("/v6")
  public List<HallDto> getAll() {
      return hallService.getAll();
  }

  @GetMapping("/v6/{id}")
  public HallDto getById(@PathVariable("id") Long id) {
      return hallService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return hallService.delete(id);
  }

  @PostMapping("/v6")
  public HallDto insert(@RequestBody HallDto dto) {
      return hallService.add(dto);
  }

  @PutMapping("/v6")
  public HallDto update(@RequestBody HallDto dto) {
      return hallService.update(dto);
  }
  
}
