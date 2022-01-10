package mapper;

import domain.UserHolder;
import dto.UserHolderCreateDto;
import dto.UserHolderDto;
import exception.NotFoundException;
import repository.RankRepository;

public class UserHolderMapper {

    private RankRepository rankRepository;
    private RankMapper rankMapper;

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
        userHolderDto.setAccessEnabled(userHolder.getAccessEnabled());
        userHolderDto.setRankDto(rankMapper.rankToRankDto(userHolder.getRank()));
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
        userHolder.setAccessEnabled(userHolderCreateDto.getAccessEnabled());
        userHolder.setRank(rankRepository.findById(userHolderCreateDto.getRankId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Rank with id: %d does not exists.", userHolderCreateDto.getRankId()))));
        return userHolder;
    }

}
