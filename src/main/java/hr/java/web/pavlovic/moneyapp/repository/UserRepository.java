package hr.java.web.pavlovic.moneyapp.repository;

import hr.java.web.pavlovic.moneyapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}