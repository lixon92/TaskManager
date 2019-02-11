package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.UserRepository;

import java.util.Collection;

public class UserService {
    final private UserRepository userRepository;

    public User findUser(String userLogin, String userPassword){
        for(User user : userRepository.getUserList() ){
            if (user.getLogin().equals(userLogin) && user.getPassword().equals(userPassword)){
                return user;
            }
        }
        return null;
    }

    public String getUserId(String userLogin, String userPassword) {
        return userRepository.getUserId(userLogin, userPassword);
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(String login, String firstName, String lastName, String password) {
        userRepository.createUser(login, firstName, lastName, password);
    }

    public boolean doesUserExist(String userLogin, String userPassword) {
        return userRepository.doesUserExist(userLogin, userPassword);
    }

    public Collection<User> getUserList() {
        return userRepository.getUserList();
    }
}
