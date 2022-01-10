package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.UserHolder;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class ClientCreateDto {
    private Long id;
    private Long passportNo;
    private Long reservationNo;
    private Long userHolderId;

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

    public Long getUserHolderId() {
        return userHolderId;
    }

    public void setUserHolderId(Long userHolderId) {
        this.userHolderId = userHolderId;
    }
}
