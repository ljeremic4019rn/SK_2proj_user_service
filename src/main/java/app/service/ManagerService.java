package app.service;

import app.dto.ManagerCreateDto;
import app.dto.ManagerDto;
import app.dto.ManagerUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.
 */
public interface ManagerService {

    Page<ManagerDto> findAll(Pageable pageable);

    ManagerDto add(ManagerCreateDto managerCreateDto);

    ManagerDto findById(Long id);

    void deleteById(Long id);
    void updateManagerProfile(Long id, ManagerUpdateDto managerUpdateDto);
}