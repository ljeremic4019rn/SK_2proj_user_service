package service.impl;

import dto.ClientCreateDto;
import dto.ClientDto;
import mapper.ClientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.ClientRepository;
import service.ClientService;

/**
 * Created on 10.01.2022. by Andrija inside package service.impl.
 */
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Page<ClientDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ClientDto add(ClientCreateDto clientCreateDto) {
        return null;
    }

    @Override
    public ClientDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
