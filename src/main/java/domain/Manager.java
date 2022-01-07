package domain;

import java.util.Date;

public class Manager extends User{
    private String hotelName;
    private Date hireDate;

    public Manager() {

    }


    public Manager(String username, String password, int phoneNumber, String email, Date dateOfBirth, String firstName, String lastName, String hotelName, Date hireDate) {
        super(username, password, phoneNumber, email, dateOfBirth, firstName, lastName);
        this.hotelName = hotelName;
        this.hireDate = hireDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
