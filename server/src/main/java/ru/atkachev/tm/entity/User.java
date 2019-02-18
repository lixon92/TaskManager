package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private String ID = UUID.randomUUID().toString();
    private String password;
    private String firstName;
    private String lastName;
    private String login;
    private Role role = Role.USER;

    public Role getRole() {
        return role;
    }
    public void setRole(final Role role) {
        this.role = role;
    }

    public String getID() {
        return ID;
    }
    public void setID(final String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(final String login) {
        this.login = login;
    }

}
