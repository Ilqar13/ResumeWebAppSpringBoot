package com.company.form;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity1.Country;
import com.company.entity1.EmploymentHistory;
import com.company.entity1.User;
import com.company.entity1.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.objenesis.SpringObjenesis;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;


public class UserDetailsForm {

    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String birthDate;
    private String profileDesc;
    private String nationalityID;
    private String birthPlaceID;
    private String userImageName;
    private String header;
    private String beginDate;
    private String endDate;
    private String jobDescription;

    public UserDetailsForm() {
    }

    public UserDetailsForm(User user,EmploymentHistory employmentHistory) {
       id=user.getId().toString();
       fullName=user.getName()+" "+user.getSurname();
       email=user.getEmail();
       phone=user.getPhone();
       address=user.getAddress();
       birthDate=user.getBirthDate().toString();
       profileDesc=user.getProfileDesc();
       nationalityID=user.getNationality().getId().toString();
       birthPlaceID=user.getBirthplace().getId().toString();
       userImageName=user.getUserImageName();
       header=employmentHistory.getHeader();
       beginDate=employmentHistory.getBeginDate().toString();
       endDate=employmentHistory.getEndDate().toString();
       jobDescription=employmentHistory.getJobDescription();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getNationality() {
        return nationalityID;
    }

    public void setNationality(String nationality) {
        this.nationalityID = nationality;
    }

    public String getBirthPlace() {
        return birthPlaceID;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlaceID = birthPlace;
    }

    public String getUserImageName() {
        return userImageName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserImageName(String userImageName) {
        this.userImageName = userImageName;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User setAndGetUserProperties(User user) {
        user.setName(fullName.split(" ")[0]);
        user.setSurname(fullName.split(" ")[1]);
        user.setPhone(phone);
        user.setAddress(address);
        user.setEmail(email);
        user.setProfileDesc(profileDesc);
        user.setBirthDate(Date.valueOf(birthDate));
        user.setNationality(new Country(Integer.parseInt(nationalityID)));
        user.setBirthplace(new Country(Integer.parseInt(birthPlaceID)));
        user.setUserSkillList(null);
        return user;
    }

    public EmploymentHistory seAndGetEmploymentHistoryProperties(EmploymentHistory employmentHistory){
        employmentHistory.setHeader(header);
        employmentHistory.setBeginDate(Date.valueOf(beginDate));
        employmentHistory.setEndDate(Date.valueOf(endDate));
        employmentHistory.setJobDescription(jobDescription);
        return  employmentHistory;
    }

    public String getJobDescription() {
        return jobDescription;
    }

}
