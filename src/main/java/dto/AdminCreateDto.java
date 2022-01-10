package dto;

/**
 * Created on 09.01.2022. by Andrija inside package dto.
 */
public class AdminCreateDto {
    private Long id;
    private Long userHolderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserHolderId() {
        return userHolderId;
    }

    public void setUserHolderId(Long userHolderId) {
        this.userHolderId = userHolderId;
    }
}
