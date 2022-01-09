package domain.Users_forLater;

import java.util.Date;

//@Entity
public class Moderator extends User{
    private String hotelName;
    private Date hireDate;

    public Moderator() {
        super();
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
