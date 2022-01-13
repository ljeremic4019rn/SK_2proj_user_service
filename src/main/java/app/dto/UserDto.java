package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Long phoneNumber;
    private Date birthDate;
    private Boolean accessEnabled;
    @JsonProperty("rank")
    private RankDto rankDto;
    private String role;
    private boolean verifiedMail;

    public boolean isVerifiedMail() {
        return verifiedMail;
    }

    public void setVerifiedMail(boolean verifiedMail) {
        this.verifiedMail = verifiedMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getAccessEnabled() {
        return accessEnabled;
    }

    public void setAccessEnabled(Boolean accessEnabled) {
        this.accessEnabled = accessEnabled;
    }

    public RankDto getRankDto() {
        return rankDto;
    }

    public void setRankDto(RankDto rankDto) {
        this.rankDto = rankDto;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
