package domain.Users;

import domain.Rank;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Integer phoneNumber;
    private String email;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean AccessAvailable;

    @OneToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

    public User() { //todo konstruktori
    }

    public User(String username, String password, Integer phoneNumber, String email, Date dateOfBirth, String firstName, String lastName, Rank rank) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.AccessAvailable = true;
        this.rank = rank;
    }

    public boolean isAccessAvailable() {
        return AccessAvailable;
    }

    public void setAccessAvailable(boolean accessAvailable) {
        AccessAvailable = accessAvailable;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
