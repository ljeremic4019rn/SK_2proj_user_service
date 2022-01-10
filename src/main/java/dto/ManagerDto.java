package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class ManagerDto {
    private Long id;
    private String hotel;
    private Date hireDate;
    @JsonProperty("userHolder")
    UserDto userDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public UserDto getUserHolderDto() {
        return userDto;
    }

    public void setUserHolderDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
