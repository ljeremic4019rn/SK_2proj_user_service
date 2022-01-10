package repository;

import domain.UserHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserHolderRepository extends JpaRepository<UserHolder, Long> {
    //Optional<UserHolder> findUserById(Long id);

}
