package repository;

import domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10.01.2022. by Andrija inside package repository.
 */
public interface AdminRepository extends JpaRepository<Admin,Long> {
}