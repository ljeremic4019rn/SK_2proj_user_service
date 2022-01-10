package mapper;

import domain.User;
import dto.UserCreateDto;
import dto.UserDto;
import exception.NotFoundException;
import repository.RankRepository;

public class UserMapper {

    private RankRepository rankRepository;
    private RankMapper rankMapper;

    public UserMapper() {
    }


    public UserDto userHolderToUserHolderDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());

        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setAccessEnabled(user.getAccessEnabled());
        userDto.setRankDto(rankMapper.rankToRankDto(user.getRank()));
        return userDto;
    }

    public User userHolderCreateDtoToUserHolder(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setBirthDate(userCreateDto.getBirthDate());
        user.setAccessEnabled(userCreateDto.getAccessEnabled());
        user.setRank(rankRepository.findById(userCreateDto.getRankId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Rank with id: %d does not exists.", userCreateDto.getRankId()))));
        return user;
    }

}
