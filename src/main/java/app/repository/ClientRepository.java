package app.repository;

import app.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10.01.2022. by Andrija inside package app.repository.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
}