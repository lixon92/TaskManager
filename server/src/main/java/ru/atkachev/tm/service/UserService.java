package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.UserRepository;

import java.util.List;

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

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(String login, String firstName, String lastName, String password) {
        userRepository.createUser(login, firstName, lastName, password);
    }

    public List<User> getUserList() {
        return userRepository.getUserList();
    }

}
