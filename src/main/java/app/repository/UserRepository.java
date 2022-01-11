package app.repository;

import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional<User> findUserById(Long id); nema potrebe jer ima metoda findById iz JpaRepository
    Optional<User> findUserByEmailAndPassword(String email, String password);

}
