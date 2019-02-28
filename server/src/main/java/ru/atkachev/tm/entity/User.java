package ru.atkachev.tm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class User implements Serializable {

    @Id
    private String Id = UUID.randomUUID().toString();
    private String password;
    private String firstName;
    private String lastName;
    private String login;
    private Role role = Role.ADMIN;

    public User(){

    }

    public Role getRole() {
        return role;
    }
    public void setRole(final Role role) {
        this.role = role;
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
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
