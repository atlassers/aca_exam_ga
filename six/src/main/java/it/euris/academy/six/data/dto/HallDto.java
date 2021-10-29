package it.euris.academy.six.data.dto;




import java.time.LocalTime;
import java.util.List;
import Utils.UT;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Cinema;
import it.euris.academy.six.data.model.Hall;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HallDto implements Dto {

  private String idHall;
  private String nameHall;
  private String capacityHall;  
  private Boolean entrance;
  private String profit;
  private String starting;
  private String cinemaId;
  
  private List<UserDto> users;
  
  @Override
  public Hall toModel() {
    return Hall.builder().id(UT.toLong(idHall))
        .name(nameHall)
        .capacity(UT.toInteger(capacityHall))
        .profit(UT.toDouble(profit))
        .starting(UT.toInstant(starting))
        .cinemaId(Cinema.builder().id(UT.toLong(cinemaId)).build())
        .build();
  }
  
  public boolean emptyHall(Long idHall) {    
    return (LocalTime.now().isAfter(LocalTime.parse(starting)));
  }
  
}  
  
 
