package app.domain;

import javax.persistence.*;

/**
 * Created on 09.01.2022. by Andrija inside package app.domain.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNo;
    private Long reservationNo;
    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;
    @ManyToOne
    private Rank rank;

    public Client() {
    }

    public Client(String passportNo, Long reservationNo, User user, Rank rank) {
        this.passportNo = passportNo;
        this.reservationNo = reservationNo;
        this.user = user;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Long getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Long reservationNo) {
        this.reservationNo = reservationNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
