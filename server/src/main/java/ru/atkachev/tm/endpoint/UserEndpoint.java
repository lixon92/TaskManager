package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public class UserEndpoint {
    final private UserService userEndpoint;

    public UserEndpoint(
            @WebParam(name = "userService")final UserService userService){
        this.userEndpoint = userService;
    }
    @WebMethod
    public User findUser(
            @WebParam(name = "userLogin")final String userLogin,
            @WebParam(name = "userPassword")final String userPassword) {
        return userEndpoint.findUser(userLogin, userPassword);
    }
    @WebMethod
    public void createUser(
            @WebParam(name = "login")final String login,
            @WebParam(name = "firstName")final String firstName,
            @WebParam(name = "lastName")final String lastName,
            @WebParam(name = "password")final String password) {
        userEndpoint.createUser(login, firstName, lastName, password);
    }
    @WebMethod
    public boolean doesUserExist(
            @WebParam(name = "userLogin") final String userLogin,
            @WebParam(name = "userPassword") final String userPassword) {
        return userEndpoint.doesUserExist(userLogin, userPassword);
    }
    @WebMethod
    public String getUserId(
            @WebParam(name = "userLogin")final String userLogin,
            @WebParam(name = "userPassword")final String userPassword) {
        return userEndpoint.getUserId(userLogin, userPassword);
    }

    @WebMethod
    public Collection<User> getUserList() {
        return userEndpoint.getUserList();
    }
}
