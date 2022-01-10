package service.impl;

import dto.AdminCreateDto;
import dto.AdminDto;
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
        return null;
    }

    @Override
    public AdminDto add(AdminCreateDto adminCreateDto) {
        return null;
    }

    @Override
    public AdminDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
