/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity1;

import files2.FileUtility;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ILQAR
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
@NamedQuery(name= "User.getByEmail" ,query="SELECT u FROM User u WHERE u.email =:email")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "profile_description")
    private String profileDescription;
    @Column(name = "address")
    private String address;
    @Column(name = "birthdate")
    private Date birthdate;
    @Lob
    @Column(name = "user_image")
    private byte[] userImage;
    @Column(name = "user_image_name")
    private String userImageName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "user",fetch=FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<UserSkill> userSkillList;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "user",fetch=FetchType.EAGER)
    private EmploymentHistory employmentHistory;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "user",fetch=FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<UserAuthority> userAuthorityList;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "user",fetch=FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<UserRole> userRoleList;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne
    private Country nationality;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne
    private Country birthplace;
   // select userauthor0_.user_id as user_id3_6_0_, userauthor0_.id as id1_6_0_, userauthor0_.id as id1_6_1_, userauthor0_.authority_id as authorit2_6_1_, userauthor0_.user_id as user_id3_6_1_, authority1_.id as id1_0_2_, authority1_.authority_name as authorit2_0_2_ from user_authority userauthor0_ inner join authority authority1_ on userauthor0_.authority_id=authority1_.id where userauthor0_.user_id=?
   // select userauthor0_.user_id as user_id3_6_0_, userauthor0_.id as id1_6_0_, userauthor0_.id as id1_6_1_, userauthor0_.authority_id as authorit2_6_1_, userauthor0_.user_id as user_id3_6_1_, authority1_.id as id1_0_2_, authority1_.authority_name as authorit2_0_2_ from user_authority userauthor0_ inner join authority authority1_ on userauthor0_.authority_id=authority1_.id where userauthor0_.user_id=?
    public User() {
        System.out.println("User created");
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(Integer id, String name, String surname, String email, String phone, String profileDescription, String address, Date birthdate, Blob userImage, String userImageName, String password, Country nationality, Country birthplace) throws Exception {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.userImage = FileUtility.readBytesFromInputStream(userImage.getBinaryStream());
        this.userImageName = userImageName;
        this.password = password;
        this.nationality = nationality;
        this.birthplace = birthplace;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDesc() {
        return profileDescription;
    }

    public void setProfileDesc(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Blob getUserImage() throws Exception {
        return new SerialBlob(this.userImage);
    }

    public void setUserImage(Blob userImage) throws Exception {
        this.userImage = FileUtility.readBytesFromInputStream(userImage.getBinaryStream());
    }

    public void setEmploymentHistory(EmploymentHistory employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public List<UserAuthority> getUserAuthorityList() {
        return userAuthorityList;
    }

    public void setUserAuthorityList(List<UserAuthority> userAuthorityList) {
        this.userAuthorityList = userAuthorityList;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public String getUserImageName() {
        return userImageName;
    }

    public void setUserImageName(String userImageName) {
        this.userImageName = userImageName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSkill> getUserSkillList() {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkill> userSkillList) {
        this.userSkillList = userSkillList;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistoryList(EmploymentHistory employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", profileDescription=" + profileDescription + ", address=" + address + ", birthdate=" + birthdate + ", userImage=" + userImage + ", userImageName=" + userImageName +'}';
    }
}
