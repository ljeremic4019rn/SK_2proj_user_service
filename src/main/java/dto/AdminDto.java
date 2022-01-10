package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class AdminDto {
    private Long id;
    @JsonProperty("userHolder")
    private UserDto userDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserHolderDto() {
        return userDto;
    }

    public void setUserHolderDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
