package it.euris.academy.six.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import Utils.UT;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.CinemaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cinema")
public class Cinema implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cinema")
  private Long id;

  @Column(name = "cinema_name")
  private String name;

  @OneToMany(mappedBy = "cinemaId")  
  private List<Hall> hall;
  
  @Column(name = "cinema_profit")
  private Double profit;


  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder()
        .id(UT.numberToString(id))
        .name(name)
        .profit(UT.numberToString(profit))
        .build();           
  }

}


