package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rank;
    private Integer points;
    private Integer discountPercentage;
    @OneToMany
    private List<User> user;

    public Rank() {
    }

    public Rank(String rank, Integer points, Integer discountPercentage, User user) {
        this.rank = rank;
        this.points = points;
        this.discountPercentage = discountPercentage;
        this.user = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<User> getUserHolder() {
        return user;
    }

    public void setUserHolder(List<User> user) {
        this.user = user;
    }
}
