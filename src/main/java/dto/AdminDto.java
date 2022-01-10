package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.UserHolder;

import javax.persistence.OneToOne;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class AdminDto {
    private Long id;
    @JsonProperty("userHolder")
    private UserHolderDto userHolderDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserHolderDto getUserHolderDto() {
        return userHolderDto;
    }

    public void setUserHolderDto(UserHolderDto userHolderDto) {
        this.userHolderDto = userHolderDto;
    }
}
