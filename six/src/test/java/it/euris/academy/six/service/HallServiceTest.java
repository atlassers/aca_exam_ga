package it.euris.academy.six.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import it.euris.academy.six.data.dto.HallDto;
import it.euris.academy.six.data.model.Hall;
import it.euris.academy.six.repository.HallRepository;
import it.euris.academy.six.utils.TestSupport;

@SpringBootTest
public class HallServiceTest {
  
  @Autowired
  HallService hallService;
  
  @MockBean
  HallRepository hallRepository;

  @Test
  void whenGetAll_theReturnTheMockedListOfHalls() {
    List<Hall> mockedHallList = List.of(TestSupport.createHall(1L),TestSupport.createHall(2L));
    when(hallRepository.findAll()).thenReturn(mockedHallList);
    List<HallDto> testHallList = hallService.getAll();
    
    assertEquals(mockedHallList.size(), testHallList.size());
    for(int i = 0; i<mockedHallList.size(); i++) {
      assertEquals(mockedHallList.get(i), testHallList.get(i));
    }
        
  }
  
  @Test
  void when_ThatGetById_ThenReturns_TheCorrectHall() {
    //Arrange
    final Long id = 1L;
    Hall mockedHall = TestSupport.createHall(id);
    when(hallRepository.findById(id)).thenReturn(Optional.of(mockedHall));
    //Act
    HallDto hallDto = hallService.getById(id);
    //Assert
    assertEquals(mockedHall.toDto(), hallDto);
    
  }
}
