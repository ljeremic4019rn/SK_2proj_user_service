package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created on 09.01.2022. by Andrija inside package app.dto.
 */
public class ClientDto {
    private Long id;
    private Long passportNo;
    private Long reservationNo;
    @JsonProperty("user")
    private UserDto userDto;
    @JsonProperty("rank")
    private RankDto rankDto;

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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RankDto getRankDto() {
        return rankDto;
    }

    public void setRankDto(RankDto rankDto) {
        this.rankDto = rankDto;
    }
}
