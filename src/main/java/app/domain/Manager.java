package app.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created on 09.01.2022. by Andrija inside package app.domain.
 */
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotel;
    private LocalDate hireDate;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;

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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
