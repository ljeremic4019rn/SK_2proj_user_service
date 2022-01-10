package dto;

/**
 * Created on 10.01.2022. by Andrija inside package dto.
 */
public class TokenResponseDto {
    private String token;

    public TokenResponseDto() {
    }

    public TokenResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
