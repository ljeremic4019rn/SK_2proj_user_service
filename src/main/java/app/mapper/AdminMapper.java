package app.mapper;

import app.domain.Admin;
import app.dto.AdminCreateDto;
import app.dto.AdminDto;
import app.exception.NotFoundException;
import app.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created on 10.01.2022. by Andrija inside package app.mapper.
 */
@Component
public class AdminMapper {
    private UserMapper userMapper;
    private UserRepository userRepository;

    public AdminMapper(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public AdminDto adminToAdminDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setUserDto(userMapper.userToUserDto(admin.getUser()));
        return adminDto;
    }

    public Admin adminCreateDtoToAdmin(AdminCreateDto adminCreateDto){
        Admin admin = new Admin();
      //  admin.setId(adminCreateDto.getId());
        admin.setUser(userRepository.findById(adminCreateDto.getUserId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d does not exists.", adminCreateDto.getUserId()))));
        return admin;
    }
}
