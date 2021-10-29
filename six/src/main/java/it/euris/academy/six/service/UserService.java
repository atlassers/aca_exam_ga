package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.UserDto;

public interface UserService {

  public UserDto getById(Long id);

  public List<UserDto> getAll();

  public UserDto add(UserDto dto);

  public UserDto update(UserDto dto);

  public Boolean delete(Long id);
}
