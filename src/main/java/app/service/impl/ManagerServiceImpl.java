package app.service.impl;

import app.domain.Manager;
import app.dto.ManagerCreateDto;
import app.dto.ManagerDto;
import app.exception.NotFoundException;
import app.mapper.ManagerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.repository.ManagerRepository;
import app.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.impl.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public Page<ManagerDto> findAll(Pageable pageable) {
        return managerRepository.findAll(pageable)
                .map(managerMapper::managerToManagerDto);
    }

    @Override
    public ManagerDto add(ManagerCreateDto managerCreateDto) {
        Manager manager = managerMapper.managerCreateDtoToManager(managerCreateDto);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public ManagerDto findById(Long id) {
        return managerRepository.findById((id))
                .map(managerMapper::managerToManagerDto)
                .orElseThrow(() -> new NotFoundException(String.format("Manager with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById((id));
    }
}
