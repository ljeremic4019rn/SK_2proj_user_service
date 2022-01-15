package app.service;

import app.dto.ClientCreateDto;
import app.dto.ClientDto;
import app.dto.ClientUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.
 */
public interface ClientService {

    Page<ClientDto> findAll(Pageable pageable);

    ClientDto add(ClientCreateDto clientCreateDto);

    ClientDto findById(Long id);

    void deleteById(Long id);

    void updateCLientProfile(Long id, ClientUpdateDto clientUpdateDto);
}