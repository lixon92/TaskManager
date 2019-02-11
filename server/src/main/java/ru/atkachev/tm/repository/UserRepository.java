package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.User;

import java.util.*;

public class UserRepository {
    final private Map<String, User> userMap = new HashMap<>();

    public void createUser(String login, String firstName, String lastName, String password){
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        userMap.put(user.getID(), user);
    }

    public boolean doesUserExist(String userLogin, String userPassword){
        for (User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword)){
                return true;
            }
        }
        return false;
    }

    public String getUserId(String userLogin, String userPassword){
        for (User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword)){
                return user.getID();
            }
        }
        return null;
    }


    public Collection<User> getUserList(){
        return userMap.values();
    }
}
