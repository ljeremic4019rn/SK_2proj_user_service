package app.mapper;

import app.domain.Manager;
import app.dto.ManagerCreateDto;
import app.dto.ManagerDto;
import app.exception.NotFoundException;
import app.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created on 10.01.2022. by Andrija inside package app.mapper.
 */
@Component
public class ManagerMapper {

    private UserMapper userMapper;
    private UserRepository userRepository;


    public ManagerDto managerToManagerDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setHireDate(manager.getHireDate());
        managerDto.setHotel(manager.getHotel());
        managerDto.setUserDto(userMapper.userToUserDto(manager.getUser()));
        return managerDto;
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDtoDto){
        Manager manager = new Manager();
      //  manager.setId(managerCreateDtoDto.getId());
        manager.setHireDate(managerCreateDtoDto.getHireDate());
        manager.setHotel(managerCreateDtoDto.getHotel());
        manager.setUser(userRepository.findById(managerCreateDtoDto.getUserId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d does not exists.", managerCreateDtoDto.getUserId()))));
        return manager;
    }
}
