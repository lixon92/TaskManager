package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.service.UserService;

public class TestUserService {
    final private IServiceLocator serviceLocator = new Bootstrap();
    final private UserService userService = new UserService(serviceLocator);

    @Test
    public void testCreateUser() throws Exception{
        User user = userService.createUser(
                "test4",
                "name",
                "surname",
                "1234");
        System.out.println(user);
    }

    @Test
    public void testUpdateUser()throws Exception{
        User user = userService.updateUser(
                "dcefba2d-1ce8-4de9-88e4-10233bb27016",
                "test",
                "test",
                "test2",
                "test",
                Role.USER
        );
        System.out.println(user);
    }

    @Test
    public void testGetUserById()throws Exception{
        User user = userService.getUserById("e216f3ff-dd43-48c3-bad3-292204dc7c91");
        System.out.println(user);
    }

    @Test
    public void testGetUserByLogin()throws Exception{
        User user = userService.getUserByLogin("test2");
        System.out.println(user);
    }

    @Test
    public void testRemoveUser() throws Exception {
        userService.removeUser("02bcd20b-a72a-4b02-ad0f-ef664de9f1a2");
    }

}
