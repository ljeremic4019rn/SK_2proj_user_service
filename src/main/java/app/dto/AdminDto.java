package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created on 09.01.2022. by Andrija inside package app.dto.
 */
public class AdminDto {
    private Long id;
    @JsonProperty("user")
    private UserDto userDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
