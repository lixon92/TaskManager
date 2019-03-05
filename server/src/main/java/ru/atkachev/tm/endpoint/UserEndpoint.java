package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public class UserEndpoint {
    final private UserService userService;

    public UserEndpoint(
            @WebParam(name = "userService")final UserService userService
    ){
        this.userService = userService;
    }

    @WebMethod
    public void createUser(
            @WebParam(name = "login")final String login,
            @WebParam(name = "firstName")final String firstName,
            @WebParam(name = "lastName")final String lastName,
            @WebParam(name = "password")final String password
    ) {
        userService.createUser(login, firstName, lastName, password);
    }

    @WebMethod
    public User getUserByLogin(
            @WebParam(name = "userLogin")final String userLogin,
            @WebParam(name = "userPassword")final String userPassword
    ) {
        final User user = userService.getUserByLogin(userLogin);
        if(user.getPassword().equals(userPassword)) return user;
        return null;
    }

    @WebMethod
    public Collection<User> getUserList() {
        return userService.getUserList();
    }
}
