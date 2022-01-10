package service;

import dto.ClientCreateDto;
import dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 10.01.2022. by Andrija inside package service.
 */
public interface ClientService {

    Page<ClientDto> findAll(Pageable pageable);

    ClientDto add(ClientCreateDto clientCreateDto);

    ClientDto findById(Long id);

    void deleteById(Long id);
}