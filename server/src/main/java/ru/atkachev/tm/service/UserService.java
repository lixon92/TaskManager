package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class UserService {
    final private UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    public User findUser(final String userLogin, final String userPassword){
//        for(final User user : userRepository.getUserList() ){
//            if (user.getLogin().equals(userLogin) && user.getPassword().equals(userPassword)){
//                return user;
//            }
//        }
//        return null;
//    }

    public String getUserId(final String userLogin, final String userPassword) {
        Connection connection = Util.getConnection();
        try {
            return userRepository.getUserId(connection, userLogin, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void createUser(final String login, final String firstName, final String lastName, final String password) {
        Connection connection = Util.getConnection();
        try {
            userRepository.createUser(connection, login, firstName, lastName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public boolean doesUserExist(final String userLogin, final String userPassword) {
//        return userRepository.doesUserExist(userLogin, userPassword);
//    }

//    public Collection<User> getUserList() {
//        return userRepository.getUserList();
//    }
}
