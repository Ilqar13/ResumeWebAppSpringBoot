/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity1;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ILQAR
 */
@Entity
@Table(name = "skill")
@XmlRootElement
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<UserSkill> userSkillList;

    public Skill() {
    }

    public Skill(Integer id) {
        this.id = id;
    }

    public Skill(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<UserSkill> getUserSkillList() {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkill> userSkillList) {
        this.userSkillList = userSkillList;
    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name=" + name +'}';
    }

}
