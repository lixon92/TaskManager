package ru.atkachev.tm.repository;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserRepository {

    public void createUser(final Connection connection, final String login, final String firstName, final String lastName,
                           final String password) throws SQLException {
        String sql = "INSERT INTO task_manager.user (id, login, password, role, firstName, lastName) VALUES (?, ?, ?, ?, ?, ?)";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, Role.USER.toString());
        preparedStatement.setString(5, firstName);
        preparedStatement.setString(6, lastName);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

//    public boolean doesUserExist(final String userLogin, final String userPassword){
//        for (User user : userMap.values()){
//            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword)){
//                return true;
//            }
//        }
//        return false;
//    }

    public String getUserId(final Connection connection, final String userLogin, final String userPassword) throws SQLException {
        final User user = new User();
        final String sql = "SELECT id, login, password, role, firstName, lastName FROM task_manager.user WHERE login = ? AND password = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, userLogin);
        preparedStatement.setString(2, userPassword);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            user.setID(resultSet.getString("id"));
        }

        preparedStatement.close();
        return user.getID();
    }

//    public void setUserList(Collection<User> userList){
//        for (User user : userList){
//            userMap.put(user.getID(), user);
//        }
//    }

//    public Collection<User> getUserList(){
//        return userMap.values();
//    }
}
