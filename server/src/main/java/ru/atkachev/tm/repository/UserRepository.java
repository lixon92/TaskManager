package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    final private List<User> userList = new ArrayList<>();

    public void createUser(String login, String firstName, String lastName, String password){
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        userList.add(user);
    }

    public void deleteUser(){
        for (final User user : userList){

        }
    }

    public List<User> getUserList(){
        return userList;
    }
}
