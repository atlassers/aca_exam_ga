package it.euris.academy.six.utils;

import it.euris.academy.six.data.model.Cinema;
import it.euris.academy.six.data.model.Hall;

public class TestSupport {

  public static Hall createHall(Long id) {
    Long idCinema =  1L;
    return Hall.builder().id(id)
        .name("Sala 1")
        .capacity(120)
        .cinemaId(TestSupport.createCinema(idCinema))
        .build();
    
  }
  
  public static Cinema createCinema(Long id) {
    return Cinema.builder().id(id).build();
    
  }
  
}
