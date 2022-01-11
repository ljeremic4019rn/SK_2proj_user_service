package app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private Integer points;
    private Integer lowerLimit;
    private Integer upperLimit;
    private Integer discountPercentage;
    @OneToMany
    private List<User> user;

    public Rank() {
    }

    public Rank(String name, Integer lowerLimit, Integer upperLimit, Integer discountPercentage) {
        this.name = name;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.discountPercentage = discountPercentage;
        this.user = new ArrayList<>();
    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
