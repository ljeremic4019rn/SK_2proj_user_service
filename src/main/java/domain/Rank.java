package domain;

import javax.persistence.*;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rank;
    private Integer points;
    private Integer discountPercentage;
    @OneToOne
    private UserHolder userHolder;

    public Rank() {
    }

    public Rank(String rank, Integer points, Integer discountPercentage, UserHolder userHolder) {
        this.rank = rank;
        this.points = points;
        this.discountPercentage = discountPercentage;
        this.userHolder = userHolder;
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

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }
}
