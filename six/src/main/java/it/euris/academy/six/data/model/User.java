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
import it.euris.academy.six.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private Long id;

  @Column(name = "name_user")
  private String name;
  
  @Column(name = "surname_user")
  private String surname;
  
  @Column(name = "birthdate_user")
  private Instant birthdate;

  @OneToOne(mappedBy = "user") // FetchType.Eager?
  private Ticket ticket;
  
  @ManyToOne
  @JoinColumn(name = "hall_id", nullable = false)
  private Hall hallId;

  public User(String userId) {
    if (userId != null) {
      this.id = Long.parseLong(userId);
    }
  }

  @Override
  public UserDto toDto() {
    return UserDto.builder()
        .idUser(id == null ? null : id.toString())
        .name(name)
        .surname(surname)
        .birthdate(birthdate.toString())
        .build();
  }



}
