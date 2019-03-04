package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
@NamedQuery(name = "User.getAll", query = "SELECT u from User u")
//@NamedQuery(name = "getUserByLogin", query = "select u from User u where login = ")
public class User implements Serializable {

    @Id
    private String Id = UUID.randomUUID().toString();
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String login;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
