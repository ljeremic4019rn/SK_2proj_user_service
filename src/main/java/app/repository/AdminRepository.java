package app.repository;

import app.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10.01.2022. by Andrija inside package app.repository.
 */
public interface AdminRepository extends JpaRepository<Admin,Long> {
}