package repository;

import domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10.01.2022. by Andrija inside package repository.
 */
public interface ManagerRepository extends JpaRepository<Manager,Long> {
}