package mapper;

import domain.Admin;
import dto.AdminCreateDto;
import dto.AdminDto;
import exception.NotFoundException;
import repository.UserRepository;

/**
 * Created on 10.01.2022. by Andrija inside package mapper.
 */
public class AdminMapper {
    private UserMapper userMapper;
    private UserRepository userRepository;

    public AdminDto adminToAdminDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setUserHolderDto(userMapper.userHolderToUserHolderDto(admin.getUserHolder()));
        return adminDto;
    }

    public Admin adminDtoToAdmin(AdminCreateDto adminCreateDto){
        Admin admin = new Admin();
        admin.setId(adminCreateDto.getId());
        admin.setUserHolder(userRepository.findById(adminCreateDto.getUserHolderId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("UserHolder with id: %d does not exists.", adminCreateDto.getUserHolderId()))));
        return admin;
    }
}
