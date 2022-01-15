package app.repository;

import app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created on 10.01.2022. by Andrija inside package app.repository.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByUser_Id(Long id);
}