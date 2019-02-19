package ru.atkachev.tm.repository;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;

import java.util.*;

public class UserRepository {

    public UserRepository(){
        init();
    }

    final private Map<String, User> userMap = new HashMap<>();

    private void init(){
        final User adminUser = new User();
        adminUser.setLogin("f");
        adminUser.setPassword(DigestUtils.md5Hex("f"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setRole(Role.ADMIN);
        userMap.put("admin", adminUser);
    }

    public void createUser(final String login, final String firstName, final String lastName, final String password){
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        userMap.put(user.getID(), user);
    }

    public boolean doesUserExist(final String userLogin, final String userPassword){
        for (User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword)){
                return true;
            }
        }
        return false;
    }

    public String getUserId(final String userLogin, final String userPassword){
        for (final User user : userMap.values()){
            if ( user.getLogin().equals(userLogin ) && user.getPassword().equals(userPassword) ){
                return user.getID();
            }
        }
        return null;
    }

    public void setUserList(Collection<User> userList){
        for (User user : userList){
            userMap.put(user.getID(), user);
        }
    }

    public Collection<User> getUserList(){
        return userMap.values();
    }
}
