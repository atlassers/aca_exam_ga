package it.euris.academy.six.data.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Utf8;
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
@Data
@Builder
public class TicketDto implements Dto {

  private String idTicket;
  private String seatTicket;
  private String price;
  
  @JsonIgnore  
  private User user;
  
  @Override
  public Ticket toModel() {
    return Ticket.builder().id(UT.toLong(idTicket))
        .seat(seatTicket)
        .price(UT.toDouble(price))
        .build();
  }
  
  public Double getTicketDiscount(UserDto userDto) { 
      double discount = UT.toDouble(price);
    if (userDto.getAge(userDto)< 5) {
      discount = discount*0.5;
    }else if (userDto.getAge(userDto) > 70)
      discount = discount*0.9;
    return discount;    
  }
}
