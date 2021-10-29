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
import it.euris.academy.six.data.dto.UserDto;
import it.euris.academy.six.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/v6")
  public List<UserDto> getAll() {
      return userService.getAll();
  }

  @GetMapping("/v6/{id}")
  public UserDto getById(@PathVariable("id") Long id) {
      return userService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return userService.delete(id);
  }

  @PostMapping("/v6")
  public UserDto insert(@RequestBody UserDto dto) {
      return userService.add(dto);
  }

  @PutMapping("/v6")
  public UserDto update(@RequestBody UserDto dto) {
      return userService.update(dto);
  }

}
