package app.mapper;

import app.domain.Manager;
import app.domain.User;
import app.dto.ManagerCreateDto;
import app.dto.ManagerDto;
import app.exception.NotFoundException;
import app.repository.RankRepository;
import app.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created on 10.01.2022. by Andrija inside package app.mapper.
 */
@Component
public class ManagerMapper {

    private UserMapper userMapper;
    private UserRepository userRepository;
    private RankRepository rankRepository;

    public ManagerMapper(UserMapper userMapper, UserRepository userRepository, RankRepository rankRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.rankRepository = rankRepository;
    }

    public ManagerDto managerToManagerDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setHireDate(manager.getHireDate());
        managerDto.setHotel(manager.getHotel());
        managerDto.setUserDto(userMapper.userToUserDto(manager.getUser()));
        return managerDto;
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDtoDto){
        User user = new User();
        user.setEmail(managerCreateDtoDto.getEmail());
        user.setFirstName(managerCreateDtoDto.getFirstName());
        user.setLastName(managerCreateDtoDto.getLastName());
        user.setUsername(managerCreateDtoDto.getUsername());
        user.setPassword(managerCreateDtoDto.getPassword());
        user.setPhoneNumber(managerCreateDtoDto.getPhoneNumber());
        user.setBirthDate(managerCreateDtoDto.getBirthDate());
        user.setAccessEnabled(Boolean.TRUE);
        user.setRole("ROLE_MANAGER");
        userRepository.save(user);


        Manager manager = new Manager();
        manager.setHireDate(managerCreateDtoDto.getHireDate());
        manager.setHotel(managerCreateDtoDto.getHotel());
        manager.setUser(user);
        return manager;
    }
}
