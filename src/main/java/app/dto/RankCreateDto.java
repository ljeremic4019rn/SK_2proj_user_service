package app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class RankCreateDto {
    @NotEmpty(message = "name cant be empty")
    private String name;
    @Min(value = 0, message = "The value must be positive")
//    private Integer points;
//    @Min(value = 0, message = "The value must be positive")
    private Integer lowerLimit;
    @Min(value = 0, message = "The value must be positive")
    private Integer upperLimit;
    @Min(value = 0, message = "The value must be positive")
    private Integer discountPercentage;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getPoints() {
//        return points;
//    }
//
//    public void setPoints(Integer points) {
//        this.points = points;
//    }


    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
