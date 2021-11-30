
package com.company.entity1;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author ILQAR
 */
@Entity
@Table(name = "user_skill")
@XmlRootElement
public class UserSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "power")
    private int power;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne
    private Skill skill;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    public UserSkill() {
    }

    public UserSkill(Integer id) {
        this.id = id;
    }

    public UserSkill(Integer id, int power) {
        this.id = id;
        this.power = power;
    }

    public UserSkill(Integer id,User user,  Skill skill,int power) {
        this.id = id;
        this.power = power;
        this.skill = skill;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", power=" + power + ", skill=" + skill + ", user=" + user + '}';
    }
   
}
