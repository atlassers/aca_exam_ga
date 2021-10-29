package it.euris.academy.six.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Utils.UT;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@Entity
public class Ticket implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ticket")
  private Long id;

  @Column(name = "seat_ticket")
  private String seat;
  
  @Column(name = "price")
  private Double price;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Override
  public TicketDto toDto() {
    return TicketDto.builder().idTicket(UT.numberToString(id))
        .seatTicket(seat)
        .price(UT.numberToString(id)).build();
  }



}
