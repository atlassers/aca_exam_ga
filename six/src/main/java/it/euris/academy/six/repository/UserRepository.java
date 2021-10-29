package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
