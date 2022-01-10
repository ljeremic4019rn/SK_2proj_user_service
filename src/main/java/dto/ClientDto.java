package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.UserHolder;

import javax.persistence.OneToOne;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class ClientDto {
    private Long id;
    private Long passportNo;
    private Long reservationNo;
    @JsonProperty("userHolder")
    private UserHolderDto userHolderDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(Long passportNo) {
        this.passportNo = passportNo;
    }

    public Long getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Long reservationNo) {
        this.reservationNo = reservationNo;
    }

    public UserHolderDto getUserHolderDto() {
        return userHolderDto;
    }

    public void setUserHolderDto(UserHolderDto userHolderDto) {
        this.userHolderDto = userHolderDto;
    }
}
