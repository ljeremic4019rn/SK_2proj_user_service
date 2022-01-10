package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 09.01.2022. by Andrija inside package domain.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long passportNo;
    private Long reservationNo;
    @OneToOne
    private UserHolder userHolder;

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

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }
}
