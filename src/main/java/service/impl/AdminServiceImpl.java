package service.impl;

import domain.Admin;
import domain.User;
import dto.AdminCreateDto;
import dto.AdminDto;
import exception.NotFoundException;
import mapper.AdminMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.AdminRepository;
import service.AdminService;

/**
 * Created on 10.01.2022. by Andrija inside package service.impl.
 */
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private AdminMapper adminMapper;

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
