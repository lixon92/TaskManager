package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.UserRepository;

import java.util.Collection;

public class UserService {
    final private UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findUser(final String userLogin, final String userPassword){
        for(final User user : userRepository.getUserList() ){
            if (user.getLogin().equals(userLogin) && user.getPassword().equals(userPassword)){
                return user;
            }
        }
        return null;
    }

    public String getUserId(final String userLogin, final String userPassword) {
        return userRepository.getUserId(userLogin, userPassword);
    }

    public void createUser(final String login, final String firstName, final String lastName, final String password) {
        userRepository.createUser(login, firstName, lastName, password);
    }

    public User createUser(final String login, final String firstName, final String password) {
        return userRepository.createUser(login, firstName, password);
    }

    public boolean doesUserExist(final String userLogin, final String userPassword) {
        return userRepository.doesUserExist(userLogin, userPassword);
    }

    public Collection<User> getUserList() {
        return userRepository.getUserList();
    }
}
