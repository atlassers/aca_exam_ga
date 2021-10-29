package it.euris.academy.six.data.dto;


import java.time.LocalDate;
import java.time.Period;
import com.fasterxml.jackson.annotation.JsonIgnore;
import Utils.UT;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Ticket;
import it.euris.academy.six.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto implements Dto{

  private String idUser;
  private String name;
  private String surname;
  private String birthdate;
   
  private Ticket tickets;
  @Override
  public User toModel() {
    return User
        .builder()
        .id(idUser==null?null:Long.parseLong(idUser))
        .name(name)
        .surname(surname)
        .birthdate(UT.toInstant(birthdate))
        .build();
  }
  
  public Integer getAge(UserDto userDto) {
    LocalDate birthDate = LocalDate.parse(birthdate);
    Period.between(birthDate, LocalDate.now()).getYears();
    return Period.between(birthDate, LocalDate.now()).getYears();    
  }
  
  public boolean isUnderAge(UserDto userDto) {   
    return (getAge(userDto) < 18);    
  }
}
