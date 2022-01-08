package domain.Users;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Client extends User{
    private Integer passportNumber;
    private Integer numOfReservations;



    public Client() {
    }



    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Integer getNumOfReservations() {
        return numOfReservations;
    }

    public void setNumOfReservations(Integer numOfReservations) {
        this.numOfReservations = numOfReservations;
    }
}
