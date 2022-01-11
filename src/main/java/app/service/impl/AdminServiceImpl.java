package app.service.impl;

import app.domain.Admin;
import app.dto.AdminCreateDto;
import app.dto.AdminDto;
import app.dto.ManagerDto;
import app.exception.NotFoundException;
import app.mapper.AdminMapper;
import app.mapper.ManagerMapper;
import app.repository.ManagerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.repository.AdminRepository;
import app.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 10.01.2022. by Andrija inside package app.service.impl.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private AdminMapper adminMapper;

    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;


    public AdminServiceImpl(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public Page<AdminDto> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable)
                .map(adminMapper::adminToAdminDto);
    }

    @Override
    public AdminDto add(AdminCreateDto adminCreateDto) {
        Admin admin = adminMapper.adminCreateDtoToAdmin(adminCreateDto);
        adminRepository.save(admin);
        return adminMapper.adminToAdminDto(admin);
    }

    @Override
    public AdminDto findById(Long id) {
        return adminRepository.findById((id))
                .map(adminMapper::adminToAdminDto)
                .orElseThrow(() -> new NotFoundException(String.format("Admin with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById((id));
    }

}
