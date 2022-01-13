package app.notificationListener;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class NotificationDto {
    private Long id;
    private String clientEmail;
    private String text;
    @JsonProperty("type")
   // private NotificationTypeDto notificationTypeDto;
    private Date creationDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public NotificationTypeDto getNotificationTypeDto() {
//        return notificationTypeDto;
//    }
//
//    public void setNotificationTypeDto(NotificationTypeDto notificationTypeDto) {
//        this.notificationTypeDto = notificationTypeDto;
//    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
