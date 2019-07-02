package de.fhdo.passwordmanager.repository;

import de.fhdo.passwordmanager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByEmail(String email);
}
