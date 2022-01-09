package dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class RankCreateDto {
    @NotEmpty(message = "rank cant be empty")
    private String rank;
    @Min(value = 0, message = "The value must be positive")
    private Integer points;
    @Min(value = 0, message = "The value must be positive")
    private Integer discountPercentage;



    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
