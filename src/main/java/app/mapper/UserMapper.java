package app.mapper;

import app.domain.User;
import app.dto.UserCreateDto;
import app.dto.UserDto;
import app.exception.NotFoundException;
import app.repository.RankRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private RankRepository rankRepository;
    private RankMapper rankMapper;

    public UserMapper(RankRepository rankRepository, RankMapper rankMapper) {
        this.rankRepository = rankRepository;
        this.rankMapper = rankMapper;
    }

    public UserDto userToUserDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setVerifiedMail(user.isVerifiedMail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setAccessEnabled(user.getAccessEnabled());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setVerifiedMail(userCreateDto.isVerifiedMail());
        user.setPassword(userCreateDto.getPassword());
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setBirthDate(userCreateDto.getBirthDate());
        user.setAccessEnabled(userCreateDto.getAccessEnabled());
        user.setRole(userCreateDto.getRole());
        return user;
    }

}
