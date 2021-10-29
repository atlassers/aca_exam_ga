package it.euris.academy.six.data.model;


import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Utils.UT;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.HallDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hall")
@Entity
public class Hall implements Model{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_hall")
  private Long id;
  
  @Column(name = "name_hall")
  private String name;
  
  @Column(name = "capacity_hall")
  private Integer capacity;
    
  @Column(name = "entrance")
  @Builder.Default
  private Boolean entrance = true;
  
  @Column(name = "starting_date")
  private Instant starting;
  
  @Column(name = "profit_hall")
  private Double profit;
  
  @ManyToOne
  @JoinColumn(name = "cinema_id", nullable = false)
  private Cinema cinemaId;
  
  @OneToOne
  @JoinColumn(name = "movie_id")
  private Movie movieId;
  
  @OneToMany(mappedBy = "hallId") 
  private List<User> users;
  
  public Hall(String hallId) {
      if (hallId != null) {
          this.id = Long.parseLong(hallId);
      }
  }
  
  @Override
  public HallDto toDto() {
    return HallDto.builder()
        .idHall(UT.numberToString(id))        
        .nameHall(name)
        .capacityHall(UT.numberToString(capacity))
        .starting(starting.toString())
        .cinemaId(cinemaId.getId().toString())
        .build();
  
}
}  