package mapper;

import domain.Manager;
import dto.ManagerCreateDto;
import dto.ManagerDto;
import exception.NotFoundException;
import repository.UserHolderRepository;

/**
 * Created on 10.01.2022. by Andrija inside package mapper.
 */
public class ManagerMapper {

    private UserHolderMapper userHolderMapper;
    private UserHolderRepository userHolderRepository;


    public ManagerDto managerToManagerDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setHireDate(manager.getHireDate());
        managerDto.setHotel(manager.getHotel());
        managerDto.setUserHolderDto(userHolderMapper.userHolderToUserHolderDto(manager.getUserHolder()));
        return managerDto;
    }

    public Manager managerDtoToManager(ManagerCreateDto managerCreateDtoDto){
        Manager manager = new Manager();
        manager.setId(managerCreateDtoDto.getId());
        manager.setHireDate(managerCreateDtoDto.getHireDate());
        manager.setHotel(managerCreateDtoDto.getHotel());
        manager.setUserHolder(userHolderRepository.findById(managerCreateDtoDto.getUserHolderId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("UserHolder with id: %d does not exists.", managerCreateDtoDto.getUserHolderId()))));
        return manager;
    }
}
