package com.company.entity1;

import javax.persistence.*;

@Entity
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "authority_id", nullable = false)
    private Authority authority;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
                "id=" + id +
                ", authority=" + authority +
                ", user=" + user +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
