package domain;

import java.util.Date;

public class Client extends User{

    private int passportNumber;
    private int numberOfReservation;

    public Client() {
    }

    public Client(String username, String password, int phoneNumber, String email, Date dateOfBirth, String firstName, String lastName, int passportNumber, int numberOfReservation) {
        super(username, password, phoneNumber, email, dateOfBirth, firstName, lastName);
        this.passportNumber = passportNumber;
        this.numberOfReservation = numberOfReservation;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getNumberOfReservation() {
        return numberOfReservation;
    }

    public void setNumberOfReservation(int numberOfReservation) {
        this.numberOfReservation = numberOfReservation;
    }
}
