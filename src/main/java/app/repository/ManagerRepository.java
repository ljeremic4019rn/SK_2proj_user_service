package app.repository;

import app.domain.Manager;
import app.dto.ManagerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created on 10.01.2022. by Andrija inside package app.repository.
 */
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Optional<Manager> findByUser_Id(Long id);
}