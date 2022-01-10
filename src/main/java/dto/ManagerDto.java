package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.UserHolder;

import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class ManagerDto {
    private Long id;
    private String hotel;
    private Date hireDate;
    @JsonProperty("userHolder")
    UserHolderDto userHolderDto;

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

    public UserHolderDto getUserHolderDto() {
        return userHolderDto;
    }

    public void setUserHolderDto(UserHolderDto userHolderDto) {
        this.userHolderDto = userHolderDto;
    }
}
