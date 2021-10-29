package it.euris.academy.six.data.dto;


import java.sql.Time;
import java.time.LocalTime;
import Utils.UT;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto implements Dto {

  private String idMovie;
  private String nameMovie;
  private String directorMovie;
  private String producerMovie;
  private String categoryMovie;
  private String length;
  private String minimunAge;
  private String price;  
  
  
  @Override
  public Movie toModel() {       
    return Movie.builder()
        .id(UT.toLong(idMovie))
        .name(nameMovie)
        .director(directorMovie)
        .producer(producerMovie)
        .category(UT.getMovieCategory(categoryMovie))
        .length(LocalTime.parse(length))
        .minimumAge(UT.toInteger(minimunAge))
        .price(UT.toDouble(price))
        .build();
  }
  


}
