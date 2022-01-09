package mapper;

import domain.UserHolder;
import dto.UserHolderCreateDto;
import dto.UserHolderDto;

public class UserHolderMapper {

    public UserHolderMapper() {
    }


    public UserHolderDto userHolderToUserHolderDto (UserHolder userHolder) {
        UserHolderDto userHolderDto = new UserHolderDto();
        userHolderDto.setId(userHolder.getId());
        userHolderDto.setEmail(userHolder.getEmail());
        userHolderDto.setFirstName(userHolder.getFirstName());
        userHolderDto.setLastName(userHolder.getLastName());
        userHolderDto.setUsername(userHolder.getUsername());

        userHolderDto.setPassword(userHolder.getPassword());
        userHolderDto.setPhoneNumber(userHolder.getPhoneNumber());
        userHolderDto.setBirthDate(userHolder.getBirthDate());
        userHolderDto.setAccessEnabled(userHolder.isAccessEnabled());
        return userHolderDto;
    }

    public UserHolder userHolderCreateDtoToUserHolder(UserHolderCreateDto userHolderCreateDto) {
        UserHolder userHolder = new UserHolder();
        userHolder.setEmail(userHolderCreateDto.getEmail());
        userHolder.setFirstName(userHolderCreateDto.getFirstName());
        userHolder.setLastName(userHolderCreateDto.getLastName());
        userHolder.setUsername(userHolderCreateDto.getUsername());
        userHolder.setPassword(userHolderCreateDto.getPassword());
        userHolder.setPhoneNumber(userHolderCreateDto.getPhoneNumber());
        userHolder.setBirthDate(userHolderCreateDto.getBirthDate());
        userHolder.setAccessEnabled(userHolderCreateDto.isAccessEnabled());
        return userHolder;
    }

}
