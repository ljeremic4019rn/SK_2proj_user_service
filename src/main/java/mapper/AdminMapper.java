package mapper;

import domain.Admin;
import domain.Client;
import dto.AdminCreateDto;
import dto.AdminDto;
import dto.ClientCreateDto;
import exception.NotFoundException;
import repository.UserHolderRepository;

/**
 * Created on 10.01.2022. by Andrija inside package mapper.
 */
public class AdminMapper {
    private UserHolderMapper userHolderMapper;
    private UserHolderRepository userHolderRepository;

    public AdminDto adminToAdminDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setUserHolderDto(userHolderMapper.userHolderToUserHolderDto(admin.getUserHolder()));
        return adminDto;
    }

    public Admin adminDtoToAdmin(AdminCreateDto adminCreateDto){
        Admin admin = new Admin();
        admin.setId(adminCreateDto.getId());
        admin.setUserHolder(userHolderRepository.findById(adminCreateDto.getUserHolderId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("UserHolder with id: %d does not exists.", adminCreateDto.getUserHolderId()))));
        return admin;
    }
}
