package com.company.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "authority")
@Entity
public class Authority {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "authority_name", nullable = false)
    private String authorityName;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authorityName='" + authorityName + '\'' +
                '}';
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}