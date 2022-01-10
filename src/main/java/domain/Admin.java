package domain;

import javax.persistence.*;


@Entity
public class Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserHolder userHolder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }
}
