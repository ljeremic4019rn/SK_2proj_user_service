package app.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created on 09.01.2022. by Andrija inside package app.dto.
 */
public class ClientCreateDto {
    private String passportNo;
    private Long reservationNo;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Long phoneNumber;
    private String birthDate;
    private String rankName;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

//    public void setBirthDate(String birthDate) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate parsedBDate = LocalDate.parse(birthDate, dateTimeFormatter);
//        this.birthDate = parsedBDate;
//    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
