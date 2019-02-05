package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private String ID = UUID.randomUUID().toString();
    private String password;
    private String firstName;
    private String lastName;
    private String login;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
