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
import it.euris.academy.six.data.dto.TicketDto;
import it.euris.academy.six.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @GetMapping("/v6")
  public List<TicketDto> getAll() {
      return ticketService.getAll();
  }

  @GetMapping("/v6/{id}")
  public TicketDto getById(@PathVariable("id") Long id) {
      return ticketService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return ticketService.delete(id);
  }

  @PostMapping("/v6")
  public TicketDto insert(@RequestBody TicketDto dto) {
      return ticketService.add(dto);
  }

  @PutMapping("/v6")
  public TicketDto update(@RequestBody TicketDto dto) {
      return ticketService.update(dto);
  }

}
