package domain;

import java.util.Date;

public class Admin extends User{

    public Admin() {
    }

    public Admin(String username, String password, int phoneNumber, String email, Date dateOfBirth, String firstName, String lastName) {
        super(username, password, phoneNumber, email, dateOfBirth, firstName, lastName);
    }



}
