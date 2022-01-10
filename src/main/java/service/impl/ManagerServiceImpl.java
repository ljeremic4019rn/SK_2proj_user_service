package service.impl;

import dto.ManagerCreateDto;
import dto.ManagerDto;
import mapper.ClientMapper;
import mapper.ManagerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.ClientRepository;
import repository.ManagerRepository;
import service.ManagerService;

/**
 * Created on 10.01.2022. by Andrija inside package service.impl.
 */
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public Page<ManagerDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ManagerDto add(ManagerCreateDto managerCreateDto) {
        return null;
    }

    @Override
    public ManagerDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
