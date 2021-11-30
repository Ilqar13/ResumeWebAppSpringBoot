package com.company.form;

import com.company.entity1.User;

public class UserSearchForm {

    private String name;
    private String surname;

    public UserSearchForm(User user) {
        name=user.getName();
        surname=user.getSurname();
    }

    public UserSearchForm() {
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

}
